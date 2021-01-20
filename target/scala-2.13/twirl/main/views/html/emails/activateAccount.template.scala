
package views.html.emails

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.twirl.api.Html

object activateAccount extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[models.User,String,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(user: models.User, url: String)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.63*/("""

"""),format.raw/*6.1*/("""<html>
    <body>
        <p>"""),_display_(/*8.13*/messages("email.activate.account.hello", user.name.getOrElse("user"))),format.raw/*8.82*/("""</p>
        <p>"""),_display_(/*9.13*/Html(messages("email.activate.account.html.text", url))),format.raw/*9.68*/("""</p>
    </body>
</html>
"""))
      }
    }
  }

  def render(user:models.User,url:String,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(user,url)(messages)

  def f:((models.User,String) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (user,url) => (messages) => apply(user,url)(messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-19T18:31:24.516238400
                  SOURCE: D:/htwg/webtech/Play_Scrabble/app/views/emails/activateAccount.scala.html
                  HASH: ea6a576adaae55240d35a512700e6a809121660f
                  MATRIX: 35->1|72->33|434->64|590->125|620->129|678->161|767->230|811->248|886->303
                  LINES: 4->1|5->2|10->4|15->4|17->6|19->8|19->8|20->9|20->9
                  -- GENERATED --
              */
          