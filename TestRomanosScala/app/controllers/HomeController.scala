package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def decToRoman(num: Int): String = {
    num match {
      case 1 => return "I" 
      case 2 => return "II" 
      case 3 => return "III" 
      case 4 => return "IV" 
      case 5 => return "V" 
      case 6 => return "VI" 
      case 7 => return "VII" 
      case 8 => return "VIII" 
      case 9 => return "lX" 
      case 10 => return "X" 
      case aux if (aux < 20) => return ("X" + decToRoman(num - 10)) 
      case 20 => return "XX" 
      case aux if (aux < 30) => return "XX" + decToRoman(num - 20) 
      case 30 => return "XXX" 
      case aux if (aux < 40)=> return "XXX" + decToRoman(num - 30) 
      case 40 => return "XL"
      case aux if (aux < 50) => return "XL" + decToRoman(num - 40)
      case 50 => return "L"
      case aux if (aux < 60) => return "L" + decToRoman(num - 50)
      case 60 => return "LX" 
      case aux if (aux < 70)=> return "LX" + decToRoman(num - 60)
      case 70 => return "LXX" 
      case aux if (aux < 80) => return "LXX" + decToRoman(num - 70)
      case 80 => return "LXXX" 
      case aux if (aux < 90) => return "LXXX" + decToRoman(num - 80)
      case 90 => return "XC" 
      case aux if (aux < 100) => return "XC" + decToRoman(num - 90)
      case 100 => return "C" 
    }
  }

  def hello() : String = {
    return "Hola mundo"
  }

  val magicNumber = "3428"

  def codeBreaker(num: String) : String = {
    var i = 0
    var aux : String = ""
    var resulX  = ""
    var resul_  = ""
    var resul   = "" 
      for (i <- 0 to 3)
      {
        aux = num(i).toString

        if (!magicNumber.contains(aux))
        {
          resul += " ";
        }
        else
        {
          // lo contiene  en la posicion correcta
          if (i == magicNumber.indexOf(aux))
          {
            resulX += "X";
          }else{ // en otra posicion
            resul_ += "_";
          }
        }

      }
      
      return resulX + resul_ + resul 
  }



  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
}
