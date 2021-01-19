
package views.html

/*1.2*/import play.api.data.Form
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.mvc.RequestHeader
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
/*7.2*/import forms.SignInForm.Data

/**/
class signIn @javax.inject.Inject() /*9.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[Data],SocialProviderRegistry,RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*10.2*/(signInForm: Form[Data], socialProviders: SocialProviderRegistry)(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*12.2*/implicitFieldConstructor/*12.26*/ = {{ b4.vertical.fieldConstructor() }};
Seq[Any](format.raw/*10.120*/("""

"""),format.raw/*12.64*/("""

"""),_display_(/*14.2*/main(messages("sign.in.title"))/*14.33*/ {_display_(Seq[Any](format.raw/*14.35*/("""
    """),format.raw/*15.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*16.18*/messages("sign.in.credentials")),format.raw/*16.49*/("""</legend>
        """),_display_(/*17.10*/helper/*17.16*/.form(action = controllers.routes.SignInController.submit())/*17.76*/ {_display_(Seq[Any](format.raw/*17.78*/("""
            """),_display_(/*18.14*/helper/*18.20*/.CSRF.formField),format.raw/*18.35*/("""
            """),_display_(/*19.14*/b4/*19.16*/.email(signInForm("email"), Symbol("_hiddenLabel") -> messages("email"), Symbol("placeholder") -> messages("email"), Symbol("class") -> "form-control input-lg")),format.raw/*19.176*/("""
            """),_display_(/*20.14*/b4/*20.16*/.password(signInForm("password"), Symbol("_hiddenLabel") -> messages("password"), Symbol("placeholder") -> messages("password"), Symbol("class") -> "form-control input-lg")),format.raw/*20.188*/("""
            """),_display_(/*21.14*/b4/*21.16*/.checkbox(signInForm("rememberMe"), Symbol("_text") -> messages("remember.me"), Symbol("checked") -> true)),format.raw/*21.122*/("""
            """),format.raw/*22.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*24.112*/messages("sign.in")),format.raw/*24.131*/("""</button>
                </div>
            </div>
        """)))}),format.raw/*27.10*/("""

        """),format.raw/*29.9*/("""<div>
            <p class="not-a-member">"""),_display_(/*30.38*/messages("not.a.member")),format.raw/*30.62*/(""" """),format.raw/*30.63*/("""<a href=""""),_display_(/*30.73*/controllers/*30.84*/.routes.SignUpController.view),format.raw/*30.113*/("""">"""),_display_(/*30.116*/messages("sign.up.now")),format.raw/*30.139*/("""</a> | <a href=""""),_display_(/*30.156*/controllers/*30.167*/.routes.ForgotPasswordController.view()),format.raw/*30.206*/("""" title=""""),_display_(/*30.216*/messages("forgot.your.password")),format.raw/*30.248*/("""">"""),_display_(/*30.251*/messages("forgot.your.password")),format.raw/*30.283*/("""</a></p>
        </div>

        """),_display_(/*33.10*/if(socialProviders.providers.nonEmpty)/*33.48*/ {_display_(Seq[Any](format.raw/*33.50*/("""
            """),format.raw/*34.13*/("""<div class="social-providers">
                <p>"""),_display_(/*35.21*/messages("or.use.social")),format.raw/*35.46*/("""</p>
                <div>
                """),_display_(/*37.18*/for(p <- socialProviders.providers) yield /*37.53*/ {_display_(Seq[Any](format.raw/*37.55*/("""
                    """),format.raw/*38.21*/("""<a href=""""),_display_(/*38.31*/controllers/*38.42*/.routes.SocialAuthController.authenticate(p.id)),format.raw/*38.89*/("""" class="provider """),_display_(/*38.108*/p/*38.109*/.id),format.raw/*38.112*/("""" title=""""),_display_(/*38.122*/messages(p.id)),format.raw/*38.136*/(""""><img src=""""),_display_(/*38.149*/assets/*38.155*/.path(s"images/providers/${p.id}.png")),format.raw/*38.193*/("""" width="64px" height="64px" alt=""""),_display_(/*38.228*/messages(p.id)),format.raw/*38.242*/(""""></a>
                """)))}),format.raw/*39.18*/("""
                """),format.raw/*40.17*/("""</div>
            </div>
        """)))}),format.raw/*42.10*/("""

    """),format.raw/*44.5*/("""</fieldset>
""")))}),format.raw/*45.2*/("""
"""))
      }
    }
  }

  def render(signInForm:Form[Data],socialProviders:SocialProviderRegistry,request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(signInForm,socialProviders)(request,messages)

  def f:((Form[Data],SocialProviderRegistry) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (signInForm,socialProviders) => (request,messages) => apply(signInForm,socialProviders)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-19T18:31:24.843874100
                  SOURCE: D:/htwg/webtech/Play_Scrabble/app/views/signIn.scala.html
                  HASH: 0055d92a4da5698d2b45a6db2ad08158ebeae2f6
                  MATRIX: 28->1|61->29|98->61|139->97|182->135|221->169|300->243|378->280|779->342|985->465|1018->489|1088->460|1120->527|1151->532|1191->563|1231->565|1264->571|1353->633|1405->664|1452->684|1467->690|1536->750|1576->752|1618->767|1633->773|1669->788|1711->803|1722->805|1904->965|1946->980|1957->982|2151->1154|2193->1169|2204->1171|2332->1277|2374->1291|2562->1451|2603->1470|2698->1534|2737->1546|2808->1590|2853->1614|2882->1615|2919->1625|2939->1636|2990->1665|3021->1668|3066->1691|3111->1708|3132->1719|3193->1758|3231->1768|3285->1800|3316->1803|3370->1835|3434->1872|3481->1910|3521->1912|3563->1926|3642->1978|3688->2003|3761->2049|3812->2084|3852->2086|3902->2108|3939->2118|3959->2129|4027->2176|4074->2195|4085->2196|4110->2199|4148->2209|4184->2223|4225->2236|4241->2242|4301->2280|4364->2315|4400->2329|4456->2354|4502->2372|4570->2409|4605->2417|4649->2431
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|10->7|13->9|16->10|20->12|20->12|21->10|23->12|25->14|25->14|25->14|26->15|27->16|27->16|28->17|28->17|28->17|28->17|29->18|29->18|29->18|30->19|30->19|30->19|31->20|31->20|31->20|32->21|32->21|32->21|33->22|35->24|35->24|38->27|40->29|41->30|41->30|41->30|41->30|41->30|41->30|41->30|41->30|41->30|41->30|41->30|41->30|41->30|41->30|41->30|44->33|44->33|44->33|45->34|46->35|46->35|48->37|48->37|48->37|49->38|49->38|49->38|49->38|49->38|49->38|49->38|49->38|49->38|49->38|49->38|49->38|49->38|49->38|50->39|51->40|53->42|55->44|56->45
                  -- GENERATED --
              */
          