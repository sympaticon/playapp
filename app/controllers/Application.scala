package controllers

import play.api._
import play.api.mvc._
import play.api.libs.iteratee.Enumerator
import play.api.libs.Comet


/**
 * Comment
*/


object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Application is ready................................."))
  }

  
  
  
  
  
  
  //hello action
  def hel = Action {
    Ok("<script type='text/javascript'>  var cometMessage = function(event) {    console.log('Received event: ' + event)  }</script><iframe src='/comet'></iframe>").as("text/html");
  }

  def chunk = Action {
    Ok.stream(
      Enumerator("kiki", "foo", "bar").andThen(Enumerator.eof))
  }

	def comet = Action {
	  val events = Enumerator("kiki", "foo", "bar")
	  Ok.stream(events &> Comet(callback = "parent.cometMessage"))
	}
  
  
  
  
  
}