// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/harrish/Desktop/play courseork/play-java-seed/conf/routes
// @DATE:Mon Dec 10 15:15:47 IST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def Pbook(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "bookp")
    }
  
    // @LINE:17
    def Gdvd(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dvdg")
    }
  
    // @LINE:14
    def Pdvd(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "dvdp")
    }
  
    // @LINE:16
    def Gbook(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "bookg")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
