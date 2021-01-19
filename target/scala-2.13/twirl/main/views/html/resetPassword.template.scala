
package views.html

/*1.2*/import play.api.data.Form
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.mvc.RequestHeader
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import java.util.UUID

/**/
class resetPassword @javax.inject.Inject() /*8.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[String],UUID,RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(form: Form[String], token: UUID)(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.88*/("""

"""),_display_(/*11.2*/main(messages("reset.password.title"))/*11.40*/ {_display_(Seq[Any](format.raw/*11.42*/("""
    """),format.raw/*12.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*13.18*/messages("reset.password")),format.raw/*13.44*/("""</legend>
        """),_display_(/*14.10*/helper/*14.16*/.form(action = controllers.routes.ResetPasswordController.submit(token), Symbol("autocomplete") -> "off")/*14.121*/ {_display_(Seq[Any](format.raw/*14.123*/("""
            """),format.raw/*15.13*/("""<p class="info">"""),_display_(/*15.30*/messages("strong.password.info")),format.raw/*15.62*/("""</p>
            """),_display_(/*16.14*/helper/*16.20*/.CSRF.formField),format.raw/*16.35*/("""
            """),_display_(/*17.14*/passwordStrength(form("password"), Symbol("_hiddenLabel") -> messages("password"), Symbol("placeholder") -> messages("password"), Symbol("class") -> "form-control input-lg")),format.raw/*17.187*/("""
            """),format.raw/*18.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*20.112*/messages("reset")),format.raw/*20.129*/("""</button>
                </div>
            </div>
        """)))}),format.raw/*23.10*/("""
    """),format.raw/*24.5*/("""</fieldset>
""")))}),format.raw/*25.2*/("""
"""))
      }
    }
  }

  def render(form:Form[String],token:UUID,request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(form,token)(request,messages)

  def f:((Form[String],UUID) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (form,token) => (request,messages) => apply(form,token)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-19T18:31:24.805976800
                  SOURCE: D:/htwg/webtech/Play_Scrabble/app/views/resetPassword.scala.html
                  HASH: 24ba9bce260214934862ff284ae4c580140b9365
                  MATRIX: 28->1|61->29|98->61|139->97|182->135|221->169|299->199|683->261|864->347|895->352|942->390|982->392|1015->398|1104->460|1151->486|1198->506|1213->512|1328->617|1369->619|1411->633|1455->650|1508->682|1554->701|1569->707|1605->722|1647->737|1842->910|1884->924|2072->1084|2111->1101|2206->1165|2239->1171|2283->1185
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|12->8|15->9|20->9|22->11|22->11|22->11|23->12|24->13|24->13|25->14|25->14|25->14|25->14|26->15|26->15|26->15|27->16|27->16|27->16|28->17|28->17|29->18|31->20|31->20|34->23|35->24|36->25
                  -- GENERATED --
              */
          