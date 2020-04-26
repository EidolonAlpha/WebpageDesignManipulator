package jonathanHughes.htmlReader.css.extraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import jonathanHughes.htmlReader.webpage.components.css.extraction.CssExtractor;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.declaration.model.CssDeclaration;
import jonathanHughes.htmlReader.webpage.components.css.ruleset.model.CssRuleSet;

public class InternalCssExtractionTest {
	
	CssExtractor internalCSSExtractor = new CssExtractor();
	
	@Test
	public void test_invalid_data() {
		String internalCSS = "adsdoashuifoseodfjndsjnfdksbfsdnher";
		List<CssRuleSet> interalCSSList = internalCSSExtractor.extract(internalCSS);
		assertEquals(0, interalCSSList.size());
	}
	
	@Test
	public void test_extraction_of__internal_css() {
		String internalCSS = "body {  font-family: Arial, Helvetica, sans-serif;}<html></html>";
		List<CssRuleSet> interalCSSList = internalCSSExtractor.extract(internalCSS);
		assertEquals("body { font-family: Arial, Helvetica, sans-serif; }", interalCSSList.get(0).toString());
	}
	
//	@Test
//	public void test_extraction_of__internal_css_twitter_error_1() {
//		String internalCSS = ".facebook-container.arrow{display:inline-block;background:url(data:image/gif;base64,R0lGODlhpwALAPEAAJ2dnZubm21tbf///yH5BAEAAAMALAAAAACnAAsAAAJPnI+py+0Po5y0smCz3rz7LAjfSJbmGYpGyrbuC8fyTNf2jef3qvf+DwwKdYOh8YhMKgWApfMJjYqk1Kp1d8pqt1yeqgsOiymhsfmMPgASBQA7)no-repeatrightcenter;width:50px;height:10px;margin:016px;opacity:.3;-ms-filter:\"alpha(opacity=30)\"}";
//		List<CssRuleSet> interalCSSList = internalCSSExtractor.extract(internalCSS);
//		assertEquals(".facebook-container.arrow { display: inline-block; background:url(data:image/gif;base64,R0lGODlhpwALAPEAAJ2dnZubm21tbf///yH5BAEAAAMALAAAAACnAAsAAAJPnI+py+0Po5y0smCz3rz7LAjfSJbmGYpGyrbuC8fyTNf2jef3qvf+DwwKdYOh8YhMKgWApfMJjYqk1Kp1d8pqt1yeqgsOiymhsfmMPgASBQA7)no-repeatrightcenter;width:50px;height:10px;margin:016px;opacity:.3;-ms-filter:\"alpha(opacity=30)\"}", interalCSSList.get(0).toString());
//	}
	
	
	@Test
	public void test_extraction_of__internal_css_with_squared_selectors() {
		String internalCSS = "[dir='ltr'],[dir='rtl']{unicode-bidi:-webkit-isolate;unicode-bidi:isolate}bdo[dir='ltr'],bdo[dir='rtl']{unicode-bidi:bidi-override;unicode-bidi:-webkit-isolate-override;unicode-bidi:isolate-override}#logo{display:block;overflow:hidden;position:relative}#logo img{border:0;}#logo span{background:url(/images/nav_logo299.webp) no-repeat;cursor:pointer;overflow:hidden}#logocont{z-index:1;padding-left:16px;padding-right:10px;padding-top:7px}#logocont.ddl{padding-top:3px}.big #logocont{padding-left:16px;padding-right:12px}#searchform #logocont{padding-top:11px;padding-right:28px;padding-left:30px}.sbibod{background-color:#fff;height:44px;vertical-align:top;border:1px solid #dfe1e5;border-radius:8px;box-shadow:none;transition:box-shadow 200ms cubic-bezier(0.4, 0.0, 0.2, 1);}.lst{border:0;margin-top:5px;margin-bottom:0}.lst:focus{outline:none}.gsfi,.lst{font:16px arial,sans-serif;line-height:34px;height:34px !important}.lst-c{overflow:hidden}#gs_st0{line-height:44px;padding:0 8px;margin-top:-1px;position:static}.srp #gs_st0{padding:0 2px 0 8px}.gsfs{font:17px arial,sans-serif}.lsb{background:transparent;border:0;font-size:0;height:30px;outline:0;text-align:left;width:100%}.sbico{display:inline-block;height:0px;width:0px;cursor:pointer;vertical-align:middle;color:#4285f4}.sbico-c{background:transparent;border:0;float:right;height:44px;line-height:44px;margin-top:-1px;outline:0;padding-right:16px;position:relative;top:-1px}.hp .sbico-c{display:none}#sblsbb{border-bottom-left-radius:0;border-top-left-radius:0;height:44px;margin:0;padding:0;}#sbds{border:0;margin-left:-1px}.hp .nojsb,.srp .jsb{display:none}.kpbb,.kprb,.kpgb,.kpgrb{border-radius:2px;border-radius:2px;color:#fff}.kpbb:hover,.kprb:hover,.kpgb:hover,.kpgrb:hover{box-shadow:0 1px 1px rgba(0,0,0,.1);box-shadow:0 1px 1px rgba(0,0,0,.1);color:#fff}.kpbb:active,.kprb:active,.kpgb:active,.kpgrb:active{box-shadow:inset 0 1px 2px rgba(0,0,0,.3);box-shadow:inset 0 1px 2px rgba(0,0,0,.3)}.kpbb{background-image:-webkit-gradient(linear,left top,left bottom,from(#4d90fe),to(#4787ed));background-color:#4d90fe;background-image:-webkit-linear-gradient(top,#4d90fe,#4787ed);background-image:linear-gradient(top,#4d90fe,#4787ed);border:1px solid #3079ed}.kpbb:hover{background-image:-webkit-gradient(linear,left top,left bottom,from(#4d90fe),to(#357ae8));background-color:#357ae8;background-image:-webkit-linear-gradient(top,#4d90fe,#357ae8);background-image:linear-gradient(top,#4d90fe,#357ae8);border:1px solid #2f5bb7}a.kpbb:link,a.kpbb:visited{color:#fff}.kprb{background-image:-webkit-gradient(linear,left top,left bottom,from(#dd4b39),to(#d14836));background-color:#dd4b39;background-image:-webkit-linear-gradient(top,#dd4b39,#d14836);background-image:linear-gradient(top,#dd4b39,#d14836);border:1px solid #dd4b39}.kprb:hover{background-image:-webkit-gradient(linear,left top,left bottom,from(#dd4b39),to(#c53727));background-color:#c53727;background-image:-webkit-linear-gradient(top,#dd4b39,#c53727);background-image:linear-gradient(top,#dd4b39,#c53727);border:1px solid #b0281a;border-bottom-color:#af301f}.kprb:active{background-image:-webkit-gradient(linear,left top,left bottom,from(#dd4b39),to(#b0281a));background-color:#b0281a;background-image:-webkit-linear-gradient(top,#dd4b39,#b0281a);background-image:linear-gradient(top,#dd4b39,#b0281a)}.kpgb{background-image:-webkit-gradient(linear,left top,left bottom,from(#3d9400),to(#398a00));background-color:#3d9400;background-image:-webkit-linear-gradient(top,#3d9400,#398a00);background-image:linear-gradient(top,#3d9400,#398a00);border:1px solid #29691d}.kpgb:hover{background-image:-webkit-gradient(linear,left top,left bottom,from(#3d9400),to(#368200));background-color:#368200;background-image:-webkit-linear-gradient(top,#3d9400,#368200);background-image:linear-gradient(top,#3d9400,#368200);border:1px solid #2d6200}.kpgrb{background-image:-webkit-gradient(linear,left top,left bottom,from(#f5f5f5),to(#f1f1f1));background-color:#f5f5f5;background-image:-webkit-linear-gradient(top,#f5f5f5,#f1f1f1);background-image:linear-gradient(top,#f5f5f5,#f1f1f1);border:1px solid #dcdcdc;color:#555}.kpgrb:hover{background-image:-webkit-gradient(linear,left top,left bottom,from(#f8f8f8),to(#f1f1f1));background-color:#f8f8f8;background-image:-webkit-linear-gradient(top,#f8f8f8,#f1f1f1);background-image:linear-gradient(top,#f8f8f8,#f1f1f1);border:1px solid #dcdcdc;color:#333}a.kpgrb:link,a.kpgrb:visited{color:#555}#sfopt{display:inline-block;line-height:normal}.lsd{font-size:11px;position:absolute;top:3px;left:16px}.tsf{background:none}#sform{height:65px}#searchform{width:100%}.minidiv #gb{top:2px}.minidiv .sfbg{background:#fff;box-shadow:0 1px 6px 0 rgba(32,33,36,.28);height:72px;}.minidiv .sbibod{height:32px;margin:10px 0;border-radius:16px}.minidiv .visible-suggestions{border-bottom-left-radius:0;border-bottom-right-radius:0}.minidiv .sbico-c{height:32px;line-height:32px}.minidiv .sbib_b{padding-top:0}.minidiv .gsfi{font-size:14px;line-height:32px}.minidiv .gsfs{font-size:14px}.minidiv #logo img{height:28px;width:86px}#searchform.minidiv #logocont{padding:17px 34px 0}.minidiv li.sbsb_c .sbse{padding:0px 0}.minidiv .sbdd_a .sbdd_b,.minidiv .sbsb_a{border-bottom-left-radius:16px;border-bottom-right-radius:16px}.minidiv #gs_st0{line-height:32px !important}.minidiv .sbdd_a{top:32px !important}.minidiv .gsri_a{background-size:20px 20px;height:20px;width:16px}.minidiv .sbico-c .sbico{height:20px;width:20px}.hp #searchform{position:absolute;top:311px}@media only screen and (max-height:768px){.hp #searchform{top:269px}}.srp #searchform{position:absolute;top:20px;}.sfbg{height:69px;left:0;position:absolute;width:100%}.sfbgg{height:65px}#cnt{padding-top:20px;}#subform_ctrl{min-height:0px}";
		List<CssRuleSet> interalCSSList = internalCSSExtractor.extract(internalCSS);
		assertEquals("[dir='ltr'],[dir='rtl'] { unicode-bidi: -webkit-isolate; unicode-bidi: isolate; }", interalCSSList.get(0).toString());
		assertEquals("bdo[dir='ltr'],bdo[dir='rtl'] { unicode-bidi: bidi-override; unicode-bidi: -webkit-isolate-override; unicode-bidi: isolate-override; }", interalCSSList.get(1).toString());
	}
	
	@Test
	public void test_extraction_of_empty_internal_css() {
		String internalCSS = "#fatnav .toplevel, #logo { }";
		List<CssRuleSet> interalCSSList = internalCSSExtractor.extract(internalCSS);
		assertEquals("#fatnav.toplevel,#logo { }", interalCSSList.get(0).toString());
	}
	
	@Test
	public void test_extraction_of_multiple_internal_css() {
		String internalCSS = "body {  font-family: Arial, Helvetica, sans-serif;}article { float: left; padding: 20px; width: 70%; background-color: #f1f1f1; height: 300px;}<html></html>";
		List<CssRuleSet> interalCSSList = internalCSSExtractor.extract(internalCSS);
		assertEquals("body { font-family: Arial, Helvetica, sans-serif; }", interalCSSList.get(0).toString());
		assertEquals("article { float: left; padding: 20px; width: 70%; background-color: #f1f1f1; height: 300px; }", interalCSSList.get(1).toString());
		CssDeclaration secondCssDeclaration = interalCSSList.get(1).getCssDeclaration().get(0);
		assertEquals("float: left;", secondCssDeclaration.toString());
		assertEquals("float", secondCssDeclaration.getProperty());
		assertEquals("left", secondCssDeclaration.getValues().get(0));
		CssDeclaration thirdCssDeclaration = interalCSSList.get(1).getCssDeclaration().get(1);
		assertEquals("padding: 20px;", thirdCssDeclaration.toString());
		assertEquals("padding", thirdCssDeclaration.getProperty());
		assertEquals("20px", thirdCssDeclaration.getValues().get(0));
	}
	
	@Test
	public void test_extraction_css_with_media_query() {
		String css = "@media (max-width: 768px) {.w3-modal-content { width: 500px; }.w3-modal { padding-top: 50px; }}";
		List<CssRuleSet> interalCSSList = internalCSSExtractor.extract(css);
		assertEquals(2, interalCSSList.size());
		assertEquals("@media (max-width: 768px)", interalCSSList.get(0).getMediaRestrictionRule().get().toString());
		assertEquals("@media (max-width: 768px) { .w3-modal-content { width: 500px; } }", interalCSSList.get(0).toString());
		assertEquals("@media (max-width: 768px)", interalCSSList.get(1).getMediaRestrictionRule().get().toString());
		assertEquals("@media (max-width: 768px) { .w3-modal { padding-top: 50px; } }", interalCSSList.get(1).toString());
		
	}

}
