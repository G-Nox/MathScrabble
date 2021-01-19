// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/G_PC/Desktop/Scrabble/play-silhouette-seed-master/conf/routes
// @DATE:Mon Jan 18 17:25:24 CET 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
