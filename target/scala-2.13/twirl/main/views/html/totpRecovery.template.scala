
package views.html

/*1.2*/import play.api.data.Form
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.mvc.RequestHeader
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import forms.TotpRecoveryForm.Data

/**/
class totpRecovery @javax.inject.Inject() /*8.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[Data],RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(totpRecoveryForm: Form[Data])(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*11.6*/implicitFieldConstructor/*11.30*/ = {{
        b4.vertical.fieldConstructor()
    }};
Seq[Any](format.raw/*9.85*/("""

    """),format.raw/*13.6*/("""

    """),_display_(/*15.6*/main(messages("sign.in.title"))/*15.37*/ {_display_(Seq[Any](format.raw/*15.39*/("""
        """),format.raw/*16.9*/("""<fieldset class="col-md-6 col-md-offset-3">
            <legend>"""),_display_(/*17.22*/messages("sign.in.totp.recovery")),format.raw/*17.55*/("""</legend>
            """),_display_(/*18.14*/helper/*18.20*/.form(action = controllers.routes.TotpRecoveryController.submit())/*18.86*/ {_display_(Seq[Any](format.raw/*18.88*/("""
                """),_display_(/*19.18*/helper/*19.24*/.CSRF.formField),format.raw/*19.39*/("""
                """),_display_(/*20.18*/b4/*20.20*/.text(totpRecoveryForm("recoveryCode"), Symbol("_hiddenLabel") -> messages("totp.recovery.code"), Symbol("placeholder") -> messages("totp.recovery.code"), Symbol("autocomplete") -> "off", Symbol("class") -> "form-control input-lg")),format.raw/*20.251*/("""
                """),_display_(/*21.18*/b4/*21.20*/.hidden(totpRecoveryForm("userID"))),format.raw/*21.55*/("""
                """),_display_(/*22.18*/b4/*22.20*/.hidden(totpRecoveryForm("sharedKey"))),format.raw/*22.58*/("""
                """),_display_(/*23.18*/b4/*23.20*/.hidden(totpRecoveryForm("rememberMe"))),format.raw/*23.59*/("""
                """),format.raw/*24.17*/("""<div class="form-group">
                    <div>
                        <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*26.116*/messages("totp.verify")),format.raw/*26.139*/("""</button>
                    </div>
                </div>
            """)))}),format.raw/*29.14*/("""

            """),format.raw/*31.13*/("""<div>
                <p class="enter-recovery-code">"""),_display_(/*32.49*/messages("totp.lost.your.recovery.codes")),format.raw/*32.90*/(""" """),format.raw/*32.91*/("""<a href="#">"""),_display_(/*32.104*/messages("totp.contact.support")),format.raw/*32.136*/("""</a></p>
            </div>
        </fieldset>
    """)))}),format.raw/*35.6*/("""
"""))
      }
    }
  }

  def render(totpRecoveryForm:Form[Data],request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(totpRecoveryForm)(request,messages)

  def f:((Form[Data]) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (totpRecoveryForm) => (request,messages) => apply(totpRecoveryForm)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-19T18:31:24.902231500
                  SOURCE: D:/htwg/webtech/Play_Scrabble/app/views/totpRecovery.scala.html
                  HASH: 4f31c9822b88e2900cddbba3b38f2b1e14c3b217
                  MATRIX: 28->1|61->29|98->61|139->97|182->135|221->169|311->212|688->274|859->366|892->390|974->357|1009->442|1044->451|1084->482|1124->484|1161->494|1254->560|1308->593|1359->617|1374->623|1449->689|1489->691|1535->710|1550->716|1586->731|1632->750|1643->752|1896->983|1942->1002|1953->1004|2009->1039|2055->1058|2066->1060|2125->1098|2171->1117|2182->1119|2242->1158|2288->1176|2484->1344|2529->1367|2636->1443|2680->1459|2762->1514|2824->1555|2853->1556|2894->1569|2948->1601|3034->1657
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|12->8|15->9|19->11|19->11|22->9|24->13|26->15|26->15|26->15|27->16|28->17|28->17|29->18|29->18|29->18|29->18|30->19|30->19|30->19|31->20|31->20|31->20|32->21|32->21|32->21|33->22|33->22|33->22|34->23|34->23|34->23|35->24|37->26|37->26|40->29|42->31|43->32|43->32|43->32|43->32|43->32|46->35
                  -- GENERATED --
              */
          