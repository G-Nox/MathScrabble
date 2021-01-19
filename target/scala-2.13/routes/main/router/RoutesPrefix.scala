// @GENERATOR:play-routes-compiler
// @SOURCE:D:/htwg/webtech/Play_Scrabble/conf/routes
// @DATE:Tue Jan 19 18:35:20 CET 2021


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
