
package views.html

/*1.2*/import play.api.data.Form
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.mvc.RequestHeader
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import forms.SignUpForm.Data

/**/
class signUp @javax.inject.Inject() /*8.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[Data],RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(signUpForm: Form[Data])(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*11.2*/implicitFieldConstructor/*11.26*/ = {{ b4.vertical.fieldConstructor() }};
Seq[Any](format.raw/*9.79*/("""

"""),format.raw/*11.64*/("""

"""),_display_(/*13.2*/main(messages("sign.up.title"))/*13.33*/ {_display_(Seq[Any](format.raw/*13.35*/("""
    """),format.raw/*14.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*15.18*/messages("sign.up.account")),format.raw/*15.45*/("""</legend>
        """),_display_(/*16.10*/helper/*16.16*/.form(action = controllers.routes.SignUpController.submit())/*16.76*/ {_display_(Seq[Any](format.raw/*16.78*/("""
            """),_display_(/*17.14*/helper/*17.20*/.CSRF.formField),format.raw/*17.35*/("""
            """),_display_(/*18.14*/b4/*18.16*/.text(signUpForm("firstName"), Symbol("_hiddenLabel") -> messages("first.name"), Symbol("placeholder") -> messages("first.name"), Symbol("class") -> "form-control input-lg")),format.raw/*18.189*/("""
            """),_display_(/*19.14*/b4/*19.16*/.text(signUpForm("lastName"), Symbol("_hiddenLabel") -> messages("last.name"), Symbol("placeholder") -> messages("last.name"), Symbol("class") -> "form-control input-lg")),format.raw/*19.186*/("""
            """),_display_(/*20.14*/b4/*20.16*/.text(signUpForm("email"), Symbol("_hiddenLabel") -> messages("email"), Symbol("placeholder") -> messages("email"), Symbol("class") -> "form-control input-lg")),format.raw/*20.175*/("""
            """),_display_(/*21.14*/passwordStrength(signUpForm("password"), Symbol("_hiddenLabel") -> messages("password"), Symbol("placeholder") -> messages("password"), Symbol("class") -> "form-control input-lg")),format.raw/*21.193*/("""
            """),format.raw/*22.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*24.112*/messages("sign.up")),format.raw/*24.131*/("""</button>
                </div>
            </div>
            <div class="sign-in-now">
                <p>"""),_display_(/*28.21*/messages("already.a.member")),format.raw/*28.49*/(""" """),format.raw/*28.50*/("""<a href=""""),_display_(/*28.60*/controllers/*28.71*/.routes.SignInController.view),format.raw/*28.100*/("""">"""),_display_(/*28.103*/messages("sign.in.now")),format.raw/*28.126*/("""</a></p>
            </div>
        """)))}),format.raw/*30.10*/("""
    """),format.raw/*31.5*/("""</fieldset>
""")))}),format.raw/*32.2*/("""
"""))
      }
    }
  }

  def render(signUpForm:Form[Data],request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(signUpForm)(request,messages)

  def f:((Form[Data]) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (signUpForm) => (request,messages) => apply(signUpForm)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-19T18:31:24.866328900
                  SOURCE: D:/htwg/webtech/Play_Scrabble/app/views/signUp.scala.html
                  HASH: dd3cea3cc03831dd1f3b4b8c37d635e961845736
                  MATRIX: 28->1|61->29|98->61|139->97|182->135|221->169|299->206|676->268|841->350|874->374|942->345|974->412|1005->417|1045->448|1085->450|1118->456|1207->518|1255->545|1302->565|1317->571|1386->631|1426->633|1468->648|1483->654|1519->669|1561->684|1572->686|1767->859|1809->874|1820->876|2012->1046|2054->1061|2065->1063|2246->1222|2288->1237|2489->1416|2531->1430|2719->1590|2760->1609|2901->1723|2950->1751|2979->1752|3016->1762|3036->1773|3087->1802|3118->1805|3163->1828|3233->1867|3266->1873|3310->1887
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|12->8|15->9|19->11|19->11|20->9|22->11|24->13|24->13|24->13|25->14|26->15|26->15|27->16|27->16|27->16|27->16|28->17|28->17|28->17|29->18|29->18|29->18|30->19|30->19|30->19|31->20|31->20|31->20|32->21|32->21|33->22|35->24|35->24|39->28|39->28|39->28|39->28|39->28|39->28|39->28|39->28|41->30|42->31|43->32
                  -- GENERATED --
              */
          