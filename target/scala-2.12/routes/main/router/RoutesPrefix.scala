// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/harrish/Desktop/play courseork/play-java-seed/conf/routes
// @DATE:Mon Dec 10 15:15:47 IST 2018


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
