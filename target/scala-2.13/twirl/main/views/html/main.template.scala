
package views.html

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.api.mvc.RequestHeader
/*3.2*/import play.twirl.api.Html
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import views.html.helper._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[String,Option[models.User],Html,RequestHeader,Messages,AssetsFinder,WebJarsUtil,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*8.2*/(title: String, user: Option[models.User] = None)(content: Html)(implicit request: RequestHeader, messages: Messages, assets: AssetsFinder, webJarsUtil: WebJarsUtil):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.167*/("""

"""),format.raw/*10.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*16.59*/assets/*16.65*/.path("images/favicon.png")),format.raw/*16.92*/("""">
        <title>"""),_display_(/*17.17*/title),format.raw/*17.22*/("""</title>
        <link """),_display_(/*18.16*/{CSPNonce.attr}),format.raw/*18.31*/(""" """),format.raw/*18.32*/("""href="//fonts.googleapis.com/css?family=Roboto|Montserrat:400,700|Open+Sans:400,300,600" rel="stylesheet">
        <link """),_display_(/*19.16*/{CSPNonce.attr}),format.raw/*19.31*/(""" """),format.raw/*19.32*/("""href="//cdnjs.cloudflare.com/ajax/libs/ionicons/1.5.2/css/ionicons.min.css" rel="stylesheet">
        """),_display_(/*20.10*/webJarsUtil/*20.21*/.locate("bootstrap.min.css").css(CSPNonce.attrMap)),format.raw/*20.71*/("""
        """),format.raw/*21.9*/("""<link """),_display_(/*21.16*/{CSPNonce.attr}),format.raw/*21.31*/(""" """),format.raw/*21.32*/("""rel="stylesheet" href=""""),_display_(/*21.56*/assets/*21.62*/.path("styles/main.css")),format.raw/*21.86*/("""">
            <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
            <script """),_display_(/*24.22*/{CSPNonce.attr}),format.raw/*24.37*/(""" """),format.raw/*24.38*/("""src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script """),_display_(/*25.22*/{CSPNonce.attr}),format.raw/*25.37*/(""" """),format.raw/*25.38*/("""src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href=""""),_display_(/*34.48*/controllers/*34.59*/.routes.ApplicationController.index),format.raw/*34.94*/("""">SMath Scrabble</a>

                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-item nav-link" href=""""),_display_(/*38.61*/controllers/*38.72*/.routes.ApplicationController.index),format.raw/*38.107*/("""">"""),_display_(/*38.110*/messages("home")),format.raw/*38.126*/("""</a>
                        <a class="nav-item nav-link" href="https://github.com/mohiva/play-silhouette-seed">GitHub</a>
                    </div>
                </div>

                <div class="collapse navbar-collapse" id="navbarNavAltMarkup2">
                    <div class="navbar-nav">
                        """),_display_(/*45.26*/user/*45.30*/.map/*45.34*/ { u =>_display_(Seq[Any](format.raw/*45.41*/("""
                        """),format.raw/*46.25*/("""<a class="nav-link" href=""""),_display_(/*46.52*/controllers/*46.63*/.routes.ApplicationController.index),format.raw/*46.98*/("""">"""),_display_(/*46.101*/u/*46.102*/.name),format.raw/*46.107*/("""</a>
                        """),_display_(/*47.26*/if(u.loginInfo.providerID == com.mohiva.play.silhouette.impl.providers.CredentialsProvider.ID)/*47.120*/ {_display_(Seq[Any](format.raw/*47.122*/("""
                        """),format.raw/*48.25*/("""<a class="nav-item nav-link" href=""""),_display_(/*48.61*/controllers/*48.72*/.routes.ChangePasswordController.view),format.raw/*48.109*/("""">"""),_display_(/*48.112*/messages("change.password")),format.raw/*48.139*/("""</a>
                        """)))}),format.raw/*49.26*/("""
                        """),format.raw/*50.25*/("""<a class="nav-item nav-link" href=""""),_display_(/*50.61*/controllers/*50.72*/.routes.ApplicationController.signOut),format.raw/*50.109*/("""">"""),_display_(/*50.112*/messages("sign.out")),format.raw/*50.132*/("""</a>
                        """)))}/*51.26*/.getOrElse/*51.36*/ {_display_(Seq[Any](format.raw/*51.38*/("""
                        """),format.raw/*52.25*/("""<a class="nav-item nav-link" href=""""),_display_(/*52.61*/controllers/*52.72*/.routes.SignInController.view),format.raw/*52.101*/("""">"""),_display_(/*52.104*/messages("sign.in")),format.raw/*52.123*/("""</a>
                        <a class="nav-item nav-link" href=""""),_display_(/*53.61*/controllers/*53.72*/.routes.SignUpController.view),format.raw/*53.101*/("""">"""),_display_(/*53.104*/messages("sign.up")),format.raw/*53.123*/("""</a>
                        """)))}),format.raw/*54.26*/("""
                    """),format.raw/*55.21*/("""</div>
                </div>

            </nav>
        </header>
        <main class="container">
            <div class="starter-template row">
                """),_display_(/*62.18*/request/*62.25*/.flash.get("error").map/*62.48*/ { msg =>_display_(Seq[Any](format.raw/*62.57*/("""
                    """),format.raw/*63.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*65.34*/messages("error")),format.raw/*65.51*/("""</strong> """),_display_(/*65.62*/msg),format.raw/*65.65*/("""
                    """),format.raw/*66.21*/("""</div>
                """)))}),format.raw/*67.18*/("""
                """),_display_(/*68.18*/request/*68.25*/.flash.get("info").map/*68.47*/ { msg =>_display_(Seq[Any](format.raw/*68.56*/("""
                    """),format.raw/*69.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*71.34*/messages("info")),format.raw/*71.50*/("""</strong> """),_display_(/*71.61*/msg),format.raw/*71.64*/("""
                    """),format.raw/*72.21*/("""</div>
                """)))}),format.raw/*73.18*/("""
                """),_display_(/*74.18*/request/*74.25*/.flash.get("success").map/*74.50*/ { msg =>_display_(Seq[Any](format.raw/*74.59*/("""
                    """),format.raw/*75.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*77.34*/messages("success")),format.raw/*77.53*/("""</strong> """),_display_(/*77.64*/msg),format.raw/*77.67*/("""
                    """),format.raw/*78.21*/("""</div>
                """)))}),format.raw/*79.18*/("""
                """),_display_(/*80.18*/content),format.raw/*80.25*/("""
            """),format.raw/*81.13*/("""</div>
        </main>
        """),_display_(/*83.10*/webJarsUtil/*83.21*/.locate("jquery.min.js").script(CSPNonce.attrMap)),format.raw/*83.70*/("""
        """),_display_(/*84.10*/webJarsUtil/*84.21*/.locate("bootstrap.min.js").script(CSPNonce.attrMap)),format.raw/*84.73*/("""
        """),format.raw/*85.9*/("""<script """),_display_(/*85.18*/{CSPNonce.attr}),format.raw/*85.33*/(""" """),format.raw/*85.34*/("""src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
        <script """),_display_(/*86.18*/{CSPNonce.attr}),format.raw/*86.33*/(""" """),format.raw/*86.34*/("""src=""""),_display_(/*86.40*/assets/*86.46*/.path("javascripts/zxcvbnShim.js")),format.raw/*86.80*/(""""></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,user:Option[models.User],content:Html,request:RequestHeader,messages:Messages,assets:AssetsFinder,webJarsUtil:WebJarsUtil): play.twirl.api.HtmlFormat.Appendable = apply(title,user)(content)(request,messages,assets,webJarsUtil)

  def f:((String,Option[models.User]) => (Html) => (RequestHeader,Messages,AssetsFinder,WebJarsUtil) => play.twirl.api.HtmlFormat.Appendable) = (title,user) => (content) => (request,messages,assets,webJarsUtil) => apply(title,user)(content)(request,messages,assets,webJarsUtil)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-20T16:58:39.616268900
                  SOURCE: D:/htwg/webtech/Play_Scrabble/app/views/main.scala.html
                  HASH: 6c3fdafe99730878324ab2cc735cbbdd4df17384
                  MATRIX: 28->1|65->33|106->69|140->98|183->136|222->170|625->201|886->366|917->370|1222->648|1237->654|1285->681|1332->701|1358->706|1410->731|1446->746|1475->747|1625->870|1661->885|1690->886|1821->990|1841->1001|1912->1051|1949->1061|1983->1068|2019->1083|2048->1084|2099->1108|2114->1114|2159->1138|2338->1290|2374->1305|2403->1306|2525->1401|2561->1416|2590->1417|3179->1979|3199->1990|3255->2025|3492->2235|3512->2246|3569->2281|3600->2284|3638->2300|3996->2631|4009->2635|4022->2639|4067->2646|4121->2672|4175->2699|4195->2710|4251->2745|4282->2748|4293->2749|4320->2754|4378->2785|4482->2879|4523->2881|4577->2907|4640->2943|4660->2954|4719->2991|4750->2994|4799->3021|4861->3052|4915->3078|4978->3114|4998->3125|5057->3162|5088->3165|5130->3185|5180->3216|5199->3226|5239->3228|5293->3254|5356->3290|5376->3301|5427->3330|5458->3333|5499->3352|5592->3418|5612->3429|5663->3458|5694->3461|5735->3480|5797->3511|5847->3533|6046->3705|6062->3712|6094->3735|6141->3744|6191->3766|6394->3942|6432->3959|6470->3970|6494->3973|6544->3995|6600->4020|6646->4039|6662->4046|6693->4068|6740->4077|6790->4099|6991->4273|7028->4289|7066->4300|7090->4303|7140->4325|7196->4350|7242->4369|7258->4376|7292->4401|7339->4410|7389->4432|7593->4609|7633->4628|7671->4639|7695->4642|7745->4664|7801->4689|7847->4708|7875->4715|7917->4729|7978->4763|7998->4774|8068->4823|8106->4834|8126->4845|8199->4897|8236->4907|8272->4916|8308->4931|8337->4932|8460->5028|8496->5043|8525->5044|8558->5050|8573->5056|8628->5090
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|14->8|19->8|21->10|27->16|27->16|27->16|28->17|28->17|29->18|29->18|29->18|30->19|30->19|30->19|31->20|31->20|31->20|32->21|32->21|32->21|32->21|32->21|32->21|32->21|35->24|35->24|35->24|36->25|36->25|36->25|45->34|45->34|45->34|49->38|49->38|49->38|49->38|49->38|56->45|56->45|56->45|56->45|57->46|57->46|57->46|57->46|57->46|57->46|57->46|58->47|58->47|58->47|59->48|59->48|59->48|59->48|59->48|59->48|60->49|61->50|61->50|61->50|61->50|61->50|61->50|62->51|62->51|62->51|63->52|63->52|63->52|63->52|63->52|63->52|64->53|64->53|64->53|64->53|64->53|65->54|66->55|73->62|73->62|73->62|73->62|74->63|76->65|76->65|76->65|76->65|77->66|78->67|79->68|79->68|79->68|79->68|80->69|82->71|82->71|82->71|82->71|83->72|84->73|85->74|85->74|85->74|85->74|86->75|88->77|88->77|88->77|88->77|89->78|90->79|91->80|91->80|92->81|94->83|94->83|94->83|95->84|95->84|95->84|96->85|96->85|96->85|96->85|97->86|97->86|97->86|97->86|97->86|97->86
                  -- GENERATED --
              */
          