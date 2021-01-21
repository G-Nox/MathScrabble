
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
                <a class="navbar-brand" href=""""),_display_(/*34.48*/controllers/*34.59*/.routes.ApplicationController.index),format.raw/*34.94*/("""">Math Scrabble</a>

                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-item nav-link" href=""""),_display_(/*38.61*/controllers/*38.72*/.routes.ApplicationController.index),format.raw/*38.107*/("""">"""),_display_(/*38.110*/messages("home")),format.raw/*38.126*/("""</a>
                        <a class="nav-item nav-link" href="https://github.com/mohiva/play-silhouette-seed">GitHub</a>
                        <a class="nav-item nav-link" href="https://math-scrabble-frontend.herokuapp.com/">Math-Scrabble</a>
                    </div>
                </div>

                <div class="collapse navbar-collapse" id="navbarNavAltMarkup2">
                    <div class="navbar-nav">
                        """),_display_(/*46.26*/user/*46.30*/.map/*46.34*/ { u =>_display_(Seq[Any](format.raw/*46.41*/("""
                        """),format.raw/*47.25*/("""<a class="nav-link" href=""""),_display_(/*47.52*/controllers/*47.63*/.routes.ApplicationController.index),format.raw/*47.98*/("""">"""),_display_(/*47.101*/u/*47.102*/.name),format.raw/*47.107*/("""</a>
                        """),_display_(/*48.26*/if(u.loginInfo.providerID == com.mohiva.play.silhouette.impl.providers.CredentialsProvider.ID)/*48.120*/ {_display_(Seq[Any](format.raw/*48.122*/("""
                        """),format.raw/*49.25*/("""<a class="nav-item nav-link" href=""""),_display_(/*49.61*/controllers/*49.72*/.routes.ChangePasswordController.view),format.raw/*49.109*/("""">"""),_display_(/*49.112*/messages("change.password")),format.raw/*49.139*/("""</a>
                        """)))}),format.raw/*50.26*/("""
                        """),format.raw/*51.25*/("""<a class="nav-item nav-link" href=""""),_display_(/*51.61*/controllers/*51.72*/.routes.ApplicationController.signOut),format.raw/*51.109*/("""">"""),_display_(/*51.112*/messages("sign.out")),format.raw/*51.132*/("""</a>
                        """)))}/*52.26*/.getOrElse/*52.36*/ {_display_(Seq[Any](format.raw/*52.38*/("""
                        """),format.raw/*53.25*/("""<a class="nav-item nav-link" href=""""),_display_(/*53.61*/controllers/*53.72*/.routes.SignInController.view),format.raw/*53.101*/("""">"""),_display_(/*53.104*/messages("sign.in")),format.raw/*53.123*/("""</a>
                        <a class="nav-item nav-link" href=""""),_display_(/*54.61*/controllers/*54.72*/.routes.SignUpController.view),format.raw/*54.101*/("""">"""),_display_(/*54.104*/messages("sign.up")),format.raw/*54.123*/("""</a>
                        """)))}),format.raw/*55.26*/("""
                    """),format.raw/*56.21*/("""</div>
                </div>

            </nav>
        </header>
        <main class="container">
            <div class="starter-template row">
                """),_display_(/*63.18*/request/*63.25*/.flash.get("error").map/*63.48*/ { msg =>_display_(Seq[Any](format.raw/*63.57*/("""
                    """),format.raw/*64.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*66.34*/messages("error")),format.raw/*66.51*/("""</strong> """),_display_(/*66.62*/msg),format.raw/*66.65*/("""
                    """),format.raw/*67.21*/("""</div>
                """)))}),format.raw/*68.18*/("""
                """),_display_(/*69.18*/request/*69.25*/.flash.get("info").map/*69.47*/ { msg =>_display_(Seq[Any](format.raw/*69.56*/("""
                    """),format.raw/*70.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*72.34*/messages("info")),format.raw/*72.50*/("""</strong> """),_display_(/*72.61*/msg),format.raw/*72.64*/("""
                    """),format.raw/*73.21*/("""</div>
                """)))}),format.raw/*74.18*/("""
                """),_display_(/*75.18*/request/*75.25*/.flash.get("success").map/*75.50*/ { msg =>_display_(Seq[Any](format.raw/*75.59*/("""
                    """),format.raw/*76.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*78.34*/messages("success")),format.raw/*78.53*/("""</strong> """),_display_(/*78.64*/msg),format.raw/*78.67*/("""
                    """),format.raw/*79.21*/("""</div>
                """)))}),format.raw/*80.18*/("""
                """),_display_(/*81.18*/content),format.raw/*81.25*/("""
            """),format.raw/*82.13*/("""</div>
        </main>
        """),_display_(/*84.10*/webJarsUtil/*84.21*/.locate("jquery.min.js").script(CSPNonce.attrMap)),format.raw/*84.70*/("""
        """),_display_(/*85.10*/webJarsUtil/*85.21*/.locate("bootstrap.min.js").script(CSPNonce.attrMap)),format.raw/*85.73*/("""
        """),format.raw/*86.9*/("""<script """),_display_(/*86.18*/{CSPNonce.attr}),format.raw/*86.33*/(""" """),format.raw/*86.34*/("""src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
        <script """),_display_(/*87.18*/{CSPNonce.attr}),format.raw/*87.33*/(""" """),format.raw/*87.34*/("""src=""""),_display_(/*87.40*/assets/*87.46*/.path("javascripts/zxcvbnShim.js")),format.raw/*87.80*/(""""></script>
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
                  DATE: 2021-01-21T02:02:40.503896500
                  SOURCE: D:/htwg/webtech/Play_Scrabble/app/views/main.scala.html
                  HASH: e55d2982cd52a4d664b7a99e1bf1eb9c761612b2
                  MATRIX: 28->1|65->33|106->69|140->98|183->136|222->170|625->201|886->366|917->370|1222->648|1237->654|1285->681|1332->701|1358->706|1410->731|1446->746|1475->747|1625->870|1661->885|1690->886|1821->990|1841->1001|1912->1051|1949->1061|1983->1068|2019->1083|2048->1084|2099->1108|2114->1114|2159->1138|2338->1290|2374->1305|2403->1306|2525->1401|2561->1416|2590->1417|3179->1979|3199->1990|3255->2025|3491->2234|3511->2245|3568->2280|3599->2283|3637->2299|4120->2755|4133->2759|4146->2763|4191->2770|4245->2796|4299->2823|4319->2834|4375->2869|4406->2872|4417->2873|4444->2878|4502->2909|4606->3003|4647->3005|4701->3031|4764->3067|4784->3078|4843->3115|4874->3118|4923->3145|4985->3176|5039->3202|5102->3238|5122->3249|5181->3286|5212->3289|5254->3309|5304->3340|5323->3350|5363->3352|5417->3378|5480->3414|5500->3425|5551->3454|5582->3457|5623->3476|5716->3542|5736->3553|5787->3582|5818->3585|5859->3604|5921->3635|5971->3657|6170->3829|6186->3836|6218->3859|6265->3868|6315->3890|6518->4066|6556->4083|6594->4094|6618->4097|6668->4119|6724->4144|6770->4163|6786->4170|6817->4192|6864->4201|6914->4223|7115->4397|7152->4413|7190->4424|7214->4427|7264->4449|7320->4474|7366->4493|7382->4500|7416->4525|7463->4534|7513->4556|7717->4733|7757->4752|7795->4763|7819->4766|7869->4788|7925->4813|7971->4832|7999->4839|8041->4853|8102->4887|8122->4898|8192->4947|8230->4958|8250->4969|8323->5021|8360->5031|8396->5040|8432->5055|8461->5056|8584->5152|8620->5167|8649->5168|8682->5174|8697->5180|8752->5214
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|14->8|19->8|21->10|27->16|27->16|27->16|28->17|28->17|29->18|29->18|29->18|30->19|30->19|30->19|31->20|31->20|31->20|32->21|32->21|32->21|32->21|32->21|32->21|32->21|35->24|35->24|35->24|36->25|36->25|36->25|45->34|45->34|45->34|49->38|49->38|49->38|49->38|49->38|57->46|57->46|57->46|57->46|58->47|58->47|58->47|58->47|58->47|58->47|58->47|59->48|59->48|59->48|60->49|60->49|60->49|60->49|60->49|60->49|61->50|62->51|62->51|62->51|62->51|62->51|62->51|63->52|63->52|63->52|64->53|64->53|64->53|64->53|64->53|64->53|65->54|65->54|65->54|65->54|65->54|66->55|67->56|74->63|74->63|74->63|74->63|75->64|77->66|77->66|77->66|77->66|78->67|79->68|80->69|80->69|80->69|80->69|81->70|83->72|83->72|83->72|83->72|84->73|85->74|86->75|86->75|86->75|86->75|87->76|89->78|89->78|89->78|89->78|90->79|91->80|92->81|92->81|93->82|95->84|95->84|95->84|96->85|96->85|96->85|97->86|97->86|97->86|97->86|98->87|98->87|98->87|98->87|98->87|98->87
                  -- GENERATED --
              */
          