// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/harrish/Desktop/play courseork/play-java-seed/conf/routes
// @DATE:Mon Dec 10 15:15:47 IST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def Pbook: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.Pbook",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "bookp"})
        }
      """
    )
  
    // @LINE:17
    def Gdvd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.Gdvd",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dvdg"})
        }
      """
    )
  
    // @LINE:14
    def Pdvd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.Pdvd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "dvdp"})
        }
      """
    )
  
    // @LINE:16
    def Gbook: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.Gbook",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bookg"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
