import akka.actor.ActorSystem
import akka.http.scaladsl.model.ws.{Message, TextMessage}
import akka.http.scaladsl.server.Directives
import akka.stream.{ActorMaterializer, FlowShape}
import akka.stream.scaladsl.{Flow, GraphDSL, Merge}

class GameService() extends Directives {
  implicit val actorSystem = ActorSystem()
  implicit val actorMaterializer = ActorMaterializer()

  val websocketRoute = (get & parameter("playerName")) { playerName =>
    handleWebSocketMessages(flow(playerName))
  }

  def flow (playerName: String): Flow[Message, Message, Any] = Flow.fromGraph(GraphDSL.create(){ implicit builder => {
    import GraphDSL.Implicits._

    val materialization = builder.materializedValue.map(m => TextMessage(s"welcome $playerName"))
    val messagePassingFlow = builder.add(Flow[Message].map(m=>m))
    val merge = builder.add(Merge[Message](2))

    materialization ~> merge.in(0)
    merge ~> messagePassingFlow

    FlowShape(merge.in(1),messagePassingFlow.out)
  }
  })


}