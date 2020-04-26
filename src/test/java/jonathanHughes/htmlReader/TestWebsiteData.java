package jonathanHughes.htmlReader;

import java.util.ArrayList;
import java.util.List;

public class TestWebsiteData {
	
	String websiteTest1 = "<html>\r\n" + 
			"\r\n" + 
			"    <style>\r\n" + 
			"        /* for demonstration */\r\n" + 
			"        .gallery { height: 100px; background-color: #CCC;  }\r\n" + 
			"        .content { height: 200px; background-color: #EEE; }\r\n" + 
			"        .sidebar { height: 200px; background-color: #AAA; }\r\n" + 
			"        /* common */\r\n" + 
			"        .middle { display: flex; flex-direction: row; flex-wrap: wrap; }\r\n" + 
			"        /* layout-1 */\r\n" + 
			"        .middle.layout-1 .gallery { width:  100%; }\r\n" + 
			"        .middle.layout-1 .content { width:  75%; }\r\n" + 
			"        .middle.layout-1 .sidebar { width:  25%; }\r\n" + 
			"        /* layout-2 */\r\n" + 
			"        .middle.layout-2 { position: relative; }\r\n" + 
			"        .middle.layout-2 .gallery { width: 75%; margin-left: 0%; }\r\n" + 
			"        .middle.layout-2 .content { width: 75%; margin-left: 0%; }\r\n" + 
			"        .middle.layout-2 .sidebar { position: absolute; top: 0; left: 75%; width: 25%; height: 100%; float: left}\r\n" + 
			"    </style>\r\n" + 
			"\r\n" + 
			"    <div class=\"middle layout-1\">\r\n" + 
			"        <div class=\"gallery\">Gallery</div>\r\n" + 
			"        <div class=\"content\">Content (this layout works perfectly)</div>\r\n" + 
			"        <div class=\"sidebar\">Sidebar</div>\r\n" + 
			"    </div>\r\n" + 
			"\r\n" + 
			"    <hr></hr>\r\n" + 
			"\r\n" + 
			"    <div class=\"middle layout-2\">\r\n" + 
			"        <div class=\"gallery\">Gallery</div>\r\n" + 
			"        <div class=\"content\">Content (should go below gallery)</div>\r\n" + 
			"        <div class=\"sidebar\">Sidebar</div>\r\n" + 
			"    </div>\r\n" + 
			"</html>";
	
	String website1 =  "//Start of file\r\n" + 
			"<!-- You will not be a>ble to see this text. -->\r\n" + 
			"<!DOCTYPE html>\r\n" + 
			"<html lang=\"en\">\r\n" + 
			"<head>\r\n" + 
			"<title>CSS Template</title>\r\n" + 
			"<meta charset=\"utf-8\">\r\n" + 
			"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"<style>\r\n" + 
			"* {\r\n" + 
			"  box-sizing: border-box;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"body {\r\n" + 
			"  font-family: Arial, Helvetica, sans-serif;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"/* Style the header */\r\n" + 
			"header {\r\n" + 
			"  background-color: #666;\r\n" + 
			"  padding: 30px;\r\n" + 
			"  text-align: center;\r\n" + 
			"  font-size: 35px;\r\n" + 
			"  color: white;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"/* Create two columns/boxes that floats next to each other */\r\n" + 
			"nav {\r\n" + 
			"  float: left;\r\n" + 
			"  width: 30%;\r\n" + 
			"  height: 300px; /* only for demonstration, should be removed */\r\n" + 
			"  background: #ccc;\r\n" + 
			"  padding: 20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"/* Style the list inside the menu */\r\n" + 
			"nav ul {\r\n" + 
			"  list-style-type: none;\r\n" + 
			"  padding: 0;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"article {\r\n" + 
			"  float: left;\r\n" + 
			"  padding: 20px;\r\n" + 
			"  width: 70%;\r\n" + 
			"  background-color: #f1f1f1;\r\n" + 
			"  height: 300px; /* only for demonstration, should be removed */\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"/* Clear floats after the columns */\r\n" + 
			"section:after {\r\n" + 
			"  content: \"\";\r\n" + 
			"  display: table;\r\n" + 
			"  clear: both;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"/* Style the footer */\r\n" + 
			"footer {\r\n" + 
			"  background-color: #777;\r\n" + 
			"  padding: 10px;\r\n" + 
			"  text-align: center;\r\n" + 
			"  color: white;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */\r\n" + 
			"@media (max-width: 600px) {\r\n" + 
			"  nav, article {\r\n" + 
			"    width: 100%;\r\n" + 
			"    height: auto;\r\n" + 
			"  }\r\n" + 
			"}\r\n" + 
			"</style>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"\r\n" + 
			"<header>\r\n" + 
			"  <h2>Cities</h2>\r\n" + 
			"</header>\r\n" + 
			"\r\n" + 
			"<section>\r\n" + 
			"  <nav>\r\n" + 
			"    <ul>\r\n" + 
			"      <li><a href=\"#\">London</a></li>\r\n" + 
			"      <li><a href=\"#\">Paris</a></li>\r\n" + 
			"      <li><a href=\"#\">Tokyo</a></li>\r\n" + 
			"    </ul>\r\n" + 
			"  </nav>\r\n" + 
			"  \r\n" + 
			"  <article>\r\n" + 
			"    <h1>London</h1>\r\n" + 
			"    <p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>\r\n" + 
			"    <p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>\r\n" + 
			"  </article>\r\n" + 
			"</section>\r\n" + 
			"\r\n" + 
			"<footer>\r\n" + 
			"  <p>Footer</p>\r\n" + 
			"</footer>\r\n" + 
			"\r\n" + 
			"</body>\r\n" + 
			"</html>\r\n";
	
	String website2 = "\r\n" + 
			"<!DOCTYPE html>\r\n" + 
			"<html lang=\"en\">\r\n" + 
			"<head>\r\n" + 
			"    <meta charset=\"UTF-8\">\r\n" + 
			"    <meta name=\"HandheldFriendly\" content=\"True\">\r\n" + 
			"    <meta name=\"MobileOptimized\" content=\"480\">\r\n" + 
			"    <!--<meta name=\"viewport\" content=\"width=device-width, height=device-height initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">-->\r\n" + 
			"    <meta name=\"viewport\" content=\"width=device-width, height=device-height initial-scale=1, user-scalable=1\">\r\n" + 
			"\r\n" + 
			"    <title>Java Regex - Matcher</title>\r\n" + 
			"\r\n" + 
			"    <meta name=\"description\" content=\"This tutorial explains the Java Regex Matcher class which can match a pattern (regular expression) against one or more strings.\">\r\n" + 
			"    <meta name=\"keywords\"    content=\"java regular expressions regex matcher\">\r\n" + 
			"    <meta name=\"author\" content=\"Jakob Jenkov\">\r\n" + 
			"\r\n" + 
			"    <meta name=\"twitter:card\" content=\"summary_large_image\" >\r\n" + 
			"    <meta name=\"twitter:site\" content=\"@jjenkov\">\r\n" + 
			"    <meta name=\"twitter:title\" content=\"Java Regex - Matcher\">\r\n" + 
			"    <meta name=\"twitter:description\" content=\"This tutorial explains the Java Regex Matcher class which can match a pattern (regular expression) against one or more strings.\">\r\n" + 
			"    <meta name=\"twitter:creator\" content=\"@jjenkov\">\r\n" + 
			"    <meta name=\"twitter:domain\" content=\"jenkov.com\">\r\n" + 
			"\r\n" + 
			"    <meta name=\"twitter:image:src\" content=\"http://tutorials.jenkov.com/images/teaser500-300-tutorials.png\">\r\n" + 
			"\r\n" + 
			"    <meta name=\"og:type\"  content=\"article\"/>\r\n" + 
			"    <meta name=\"og:title\" content=\"Java Regex - Matcher\"/>\r\n" + 
			"    <meta property=\"og:url\"   content=\"http://tutorials.jenkov.com/java-regex/matcher.html\"/>\r\n" + 
			"    <meta property=\"og:description\" content=\"This tutorial explains the Java Regex Matcher class which can match a pattern (regular expression) against one or more strings.\"/>\r\n" + 
			"\r\n" + 
			"    <meta property=\"og:image\" content=\"http://tutorials.jenkov.com/images/teaser500-300-tutorials.png\"/>\r\n" + 
			"\r\n" + 
			"    <link href=\"https://plus.google.com/108227213807945109821\" rel=\"publisher\" />\r\n" + 
			"\r\n" + 
			"    <meta name=\"google-site-verification\" content=\"i_TwzdElg-by5uXLvyAjuIaCjxo0yjtW8LdRPUDEEcw\" />\r\n" + 
			"</head>\r\n" + 
			"\r\n" + 
			"<body>\r\n" + 
			"\r\n" + 
			"<style>\r\n" + 
			"body {background-color: #f0f0f0; xbackground-image: linear-gradient(180deg, #f0f0f0, #e0e0e0); margin: 0px; font-family: arial;}\r\n" + 
			"\r\n" + 
			".grid {\r\n" + 
			"  display: grid;\r\n" + 
			"\r\n" + 
			"}\r\n" + 
			".topBar, .footer {\r\n" + 
			"  grid-column-start: 1;\r\n" + 
			"  grid-column-end: 12;\r\n" + 
			"  background-color: #000000;\r\n" + 
			"  color: #ffffff;\r\n" + 
			"  height: 64px;\r\n" + 
			"  box-shadow: 0px 8px 6px -6px #999999;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".content {\r\n" + 
			"  grid-column-start: 1;\r\n" + 
			"  grid-column-end: 12;\r\n" + 
			"  text-align: center;\r\n" + 
			"}\r\n" + 
			".category, .main, .right {\r\n" + 
			"	display: inline-block;\r\n" + 
			"    vertical-align: top;\r\n" + 
			"	box-sizing: border-box;\r\n" + 
			"	text-align: left;\r\n" + 
			"}\r\n" + 
			".footer {\r\n" + 
			"  height: 64px;\r\n" + 
			"  position: relative;\r\n" + 
			"  padding-bottom: 48px;\r\n" + 
			"}\r\n" + 
			"#footerCopyright {\r\n" + 
			"	position: absolute;\r\n" + 
			"	top: 20px;\r\n" + 
			"	left:20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".card{ background-color: #ffffff; box-shadow: 0px 8px 6px -6px #999999;padding: 20px 30px;border: 1px solid #e0e0e0; margin: 8px 4px;}\r\n" + 
			".cardLeft  { margin-left:   8px; }\r\n" + 
			".cardRight { margin-right:  8px; }\r\n" + 
			".cardTop   { margin-top:    8px; }\r\n" + 
			".cardBottom{ margin-bottom: 8px; }\r\n" + 
			"\r\n" + 
			"#topBarMenu    { position: absolute; top: 20px; left: 20px; }\r\n" + 
			"#topBarMenu a  { color: #ffffff; text-decoration: none; }\r\n" + 
			"#topBarLogoBox { text-align: right; padding-top:6px; margin-right: 16px;}\r\n" + 
			"#topBarLogo    { height: 38px; }\r\n" + 
			"#topBarPhrase  { padding-right: 4px; font-size: 0.8em; }\r\n" + 
			"</style>\r\n" + 
			"\r\n" + 
			"<style>\r\n" + 
			"a{ text-decoration:none; }\r\n" + 
			"#main, #mainBody { text-align: left; }\r\n" + 
			"\r\n" + 
			"#mainBody h1{margin-top: 0px; text-align:left; }\r\n" + 
			"#mainBody h2{margin: 24px 0px 0px 0px; text-align:left; }\r\n" + 
			"#mainBody a{font-weight: bold; color: #339;}\r\n" + 
			"#mainBody img{max-width:100%;}\r\n" + 
			"#mainBody svg{max-width:100%;overflow: auto;}\r\n" + 
			"\r\n" + 
			".card{ background-color: #ffffff; box-shadow: 0px 8px 6px -6px #999999;padding: 20px 30px;border: 1px solid #e0e0e0;}\r\n" + 
			"#trailToc ol li{border-bottom: 1px solid #f0f0f0;padding: 4px 20px;vertical-align: top;}\r\n" + 
			".codeBox {background-color: #f0f0f0;border: 1px solid #cccccc;padding: 10px;max-width: 100%;overflow: auto;}\r\n" + 
			"code{font-size: 1.2em;}\r\n" + 
			".dataTable{background-color: #f0f0f0;border: 1px solid #cccccc;max-width: 100%;overflow: auto;}\r\n" + 
			".dataTable th{text-align: left;}\r\n" + 
			".dataTable th, .dataTable td{padding: 2px 8px; }\r\n" + 
			"#pageToc{border: 1px solid #f0f0f0; text-align:left; }\r\n" + 
			"#pageToc li{margin: 6px 0px;}\r\n" + 
			"#pageToc a{color: #339;font-weight: normal;}\r\n" + 
			"#lastUpdate{border: 1px solid #f0f0f0;border-top:none;padding: 6px 24px;font-size: 0.8em;color: #666; text-align:left; }\r\n" + 
			"#next{border-top: 1px solid #f0f0f0;padding: 10px 0px;font-size: 1.1em;}\r\n" + 
			"#bottomSocial{border-top: 1px solid #f0f0f0;padding: 10px 0px;font-size: 0.9em;}\r\n" + 
			"</style>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<style>\r\n" + 
			"@media only screen and (max-width: 799px) {\r\n" + 
			"	.main     { width: 100%;}\r\n" + 
			"	.category { display: none; }\r\n" + 
			"	.right    {	display: none; }\r\n" + 
			"	.card     { padding: 10px 8px; }\r\n" + 
			"    .bigScreen{ display: none; }\r\n" + 
			"}\r\n" + 
			"@media only screen and (min-width: 800px) and (max-width: 1199px) {\r\n" + 
			"	.main     { width: 75%; }\r\n" + 
			"	.category {	width: 25%;	}\r\n" + 
			"	.right    { display:none;}\r\n" + 
			"	.smallScreen { display: none; }\r\n" + 
			"}\r\n" + 
			"@media only screen and (min-width: 1200px) {\r\n" + 
			"	.main     { width: 50%;	max-width: 900px; }\r\n" + 
			"	.category { width: 25%;	max-width: 300px; }\r\n" + 
			"	.right    { width: 25%; max-width: 400px; display:none;}\r\n" + 
			"	.smallScreen { display: none; }\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"@media only screen and (max-width: 600px) {\r\n" + 
			"  #topBarLogo{transform: scale(0.75, 0.75) translate(0px, 0px);}\r\n" + 
			"}\r\n" + 
			"@media only screen and (max-width: 480px) {\r\n" + 
			"  #topBarLogo{transform: scale(0.6, 0.6) translate(136px, 0px);}\r\n" + 
			"  #topBarMenu a{ font-size: 0.8em; }\r\n" + 
			"  h1{ font-size: 1.6em; }\r\n" + 
			"  h2{ font-size: 1.4em; }\r\n" + 
			"  h3{ font-size: 1.2em; }\r\n" + 
			"}\r\n" + 
			"</style>\r\n" + 
			"\r\n" + 
			"<div class=\"grid\">\r\n" + 
			"\r\n" + 
			"    <div class=\"topBar\">\r\n" + 
			"\r\n" + 
			"        <div id=\"topBarMenu\">\r\n" + 
			"            <a href=\"http://tutorials.jenkov.com\" title=\"Tutorials\">Tutorials</a>\r\n" + 
			"            &nbsp;&nbsp;&nbsp;\r\n" + 
			"            <a href=\"http://jenkov.com/about/index.html\" title=\"Tutorials\">About</a>\r\n" + 
			"            &nbsp;&nbsp;&nbsp;\r\n" + 
			"            <a href=\"http://jenkov.com/rss.xml\" title=\"RSS\">RSS</a>\r\n" + 
			"        </div>\r\n" + 
			"\r\n" + 
			"        <div id=\"topBarLogoBox\">\r\n" + 
			"            <div id=\"topBarLogo\"><svg x=\"0px\" y=\"0px\" width=\"409px\" height=\"48px\" viewBox=\"0 0 409 100\" style=\"enable-background:new 0 0 409 100;\" xml:space=\"preserve\">  <path d=\"M53,32 l10,0  l0,26  c-7,21 -30,21 -53,10  l4,-9  c18,11 33,10 39,-3  z \" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M69,32 l50,0  l0,9  l-50,0 z\" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M69,49 l50,0  l0,9  l-50,0 z\" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M69,65 l50,0  l0,9  l-50,0 z\" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M126,32 l13,0  l40,31  l0,-31  l10,0  l0,42  l-10,0 l-43,-32 l0,32 l-10,0 z \" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M179,32  l10,0  l0,15 l5,0  l32.5,-14.5  l19,0  l-41,19  l40,22  l-19,0  l-33,-18  l-3.5,0  l0,19  l-10,0 z \" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M238,49  c10,-24 60,-24 70,0  l-11,0  c-10,-12 -38,-12 -48,0  z \" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M238,57  c10,24 60,24 70,0  l-11,0  c-10,12 -38,12 -48,0  z \" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M304,32  l13,0  l25,34 l25,-34  l13,0  l-32,42 l-12.5,0 z\" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M369,65  l12,0 l0,8 l-12,0 z\" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M390,53  c3,-27 54,-27 67,-10  l-15,0  c-10,-5 -40,-5 -41.5,10 l-10,0  \" style=\"stroke: none;  stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M390,53  c3,27 54,27 67,10  l-15,0  c-10,5 -40,5 -41.5,-10 l-10,0  \" style=\"stroke: none;  stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M460,49  c10,-24 60,-24 70,0  l-11,0  c-10,-12 -38,-12 -48,0  z \" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M460,57  c10,24 60,24 70,0  l-11,0  c-10,12 -38,12 -48,0  z \" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path>  <path d=\"M534,34  l10,0  l0,6 c13,-10 26,-10 37,0  c12,-10 32,-10 39,3  l0,30  l-10,0  l0,-27  c-3,-9 -24,-9 -28,3 l0,24  -10,0  l0,-27  c-3,-9 -24,-9 -28,3 l0,24  -10,0 z\" style=\"stroke: none; stroke-width: 1; fill: #ffffff;\"></path></svg></div>\r\n" + 
			"            <div id=\"topBarPhrase\">Tech and Media Labs</div>\r\n" + 
			"        </div>\r\n" + 
			"\r\n" + 
			"    </div>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"    <div class=\"content\">\r\n" + 
			"        <div class=\"site-menu\">\r\n" + 
			"\r\n" + 
			"            <!--\r\n" + 
			"              <div class=\"card cardLeft cardTop\">Software Development\r\n" + 
			"                <ul>\r\n" + 
			"                  <li>Java &amp; JVM</li>\r\n" + 
			"                  <li>Web</li>\r\n" + 
			"                  <li>Distributed Systems</li>\r\n" + 
			"                </ul>\r\n" + 
			"            </div>\r\n" + 
			"            -->\r\n" + 
			"        </div><div class=\"category\">\r\n" + 
			"        <div id=\"trailToc\" class=\"card cardTop cardBottom\">\r\n" + 
			"            <div id='trailTitle'>Java Regular Expressions</div><ol><li><a href=\"/java-regex/index.html\">Java Regex - Java Regular Expressions</a></li><li><a href=\"/java-regex/pattern.html\">Java Regex - Pattern</a></li><li><a href=\"/java-regex/matcher.html\"><b>Java Regex - Matcher</b></a></li><li><a href=\"/java-regex/syntax.html\">Java Regex - Regular Expression Syntax</a></li></ol>\r\n" + 
			"        </div>\r\n" + 
			"    </div><div class=\"main\">\r\n" + 
			"        <div class=\"card cardTop cardBottom\">\r\n" + 
			"            <h1 style=\"text-align: left;\">Java Regex - Matcher</h1>\r\n" + 
			"\r\n" + 
			"            <div id=\"pageToc\" itemscope itemtype=\"http://schema.org/SiteNavigationElement\">\r\n" + 
			"                <ul><li><a href=\"#java-matcher-example\">Java Matcher Example</a></li><li><a href=\"#creating-a-matcher\">Creating a Matcher</a></li><li><a href=\"#matches-method\">matches()</a></li><li><a href=\"#lookingat-method\">lookingAt()</a></li><li><a href=\"#find-start-end-methods\">find() + start() + end()</a></li><li><a href=\"#reset-method\">reset()</a></li><li><a href=\"#group-method\">group()</a><ul><li><a href=\"#multiple-groups\">Multiple Groups</a></li><li><a href=\"#groups-inside-groups\">Groups Inside Groups</a></li></ul></li><li><a href=\"#replaceall-replacefirst-methods\">replaceAll() + replaceFirst()</a></li><li><a href=\"#appendreplacement-appendtail-methods\">appendReplacement() + appendTail()</a></li></ul>\r\n" + 
			"            </div>\r\n" + 
			"            <div id=\"lastUpdate\">\r\n" + 
			"                <table><tr><td class=\"authorPhoto\"></td>\r\n" + 
			"                    <td><p style=\"margin: 0px 0px 6px 0px;\">\r\n" + 
			"                        Jakob Jenkov<br>\r\n" + 
			"                        Last update: 2017-11-06\r\n" + 
			"                    </p>\r\n" + 
			"                        <div class=\"authorSocialLinks\"></div>\r\n" + 
			"                    </td>\r\n" + 
			"                </tr>\r\n" + 
			"                </table>\r\n" + 
			"            </div>\r\n" + 
			"\r\n" + 
			"            <div id=\"mainBody\">\r\n" + 
			"                <p>\r\n" + 
			"    The Java <code>Matcher</code> class (<code>java.util.regex.Matcher</code>) is used to search through a text\r\n" + 
			"    for multiple occurrences of a regular expression. You can also use a <code>Matcher</code>\r\n" + 
			"    to search for the same regular expression in different texts.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    The Java <code>Matcher</code> class has a lot of useful methods. I will cover the core\r\n" + 
			"    methods of the Java <code>Matcher</code> class in this tutorial. For a full list, see\r\n" + 
			"    the official JavaDoc for the <code>Matcher</code> class.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<a name=\"java-matcher-example\"></a>\r\n" + 
			"<h2>Java Matcher Example</h2>\r\n" + 
			"<p>\r\n" + 
			"    Here is a quick Java <code>Matcher</code> example so you can get an idea of how the\r\n" + 
			"    <code>Matcher</code> class works:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"import java.util.regex.Pattern;\r\n" + 
			"import java.util.regex.Matcher;\r\n" + 
			"\r\n" + 
			"public class MatcherExample {\r\n" + 
			"\r\n" + 
			"    public static void main(String[] args) {\r\n" + 
			"\r\n" + 
			"        String text    =\r\n" + 
			"            \"This is the text to be searched \" +\r\n" + 
			"            \"for occurrences of the http:// pattern.\";\r\n" + 
			"\r\n" + 
			"        String patternString = \".*http://.*\";\r\n" + 
			"\r\n" + 
			"        Pattern pattern = Pattern.compile(patternString);\r\n" + 
			"\r\n" + 
			"        Matcher matcher = pattern.matcher(text);\r\n" + 
			"        boolean matches = matcher.matches();\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    First a <code>Pattern</code> instance is created from a regular expression, and from the <code>Pattern</code>\r\n" + 
			"    instance a <code>Matcher</code> instance is created. Then the <code>matches()</code> method is called on the\r\n" + 
			"    <code>Matcher</code> instance. The <code>matches()</code> returns <code>true</code> if the regular expression\r\n" + 
			"    matches the text, and <code>false</code> if not.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    You can do a whole lot more with the <code>Matcher</code> class. The rest is covered\r\n" + 
			"    throughout the rest of this tutorial. The <code>Pattern</code> class is covered separately in my <a href=\"pattern.html\">Java Regex Pattern tutorial</a>.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<a name=\"creating-a-matcher\"></a>\r\n" + 
			"<h2>Creating a Matcher</h2>\r\n" + 
			"<p>\r\n" + 
			"    Creating a <code>Matcher</code> is done via the <code>matcher()</code> method in the <code>Pattern</code>\r\n" + 
			"    class. Here is an example:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"import java.util.regex.Pattern;\r\n" + 
			"import java.util.regex.Matcher;\r\n" + 
			"\r\n" + 
			"public class CreateMatcherExample {\r\n" + 
			"\r\n" + 
			"    public static void main(String[] args) {\r\n" + 
			"\r\n" + 
			"        String text    =\r\n" + 
			"            \"This is the text to be searched \" +\r\n" + 
			"            \"for occurrences of the http:// pattern.\";\r\n" + 
			"\r\n" + 
			"        String patternString = \".*http://.*\";\r\n" + 
			"\r\n" + 
			"        Pattern pattern = Pattern.compile(patternString);\r\n" + 
			"\r\n" + 
			"        <b>Matcher matcher = pattern.matcher(text);</b>\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    At the end of this example the <code>matcher</code> variable will contain a <code>Matcher</code> instance which\r\n" + 
			"    can be used to match the regular expression used to create it against different text input.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<a name=\"matches-method\"></a>\r\n" + 
			"<h2>matches()</h2>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    The <code>matches()</code> method in the <code>Matcher</code> class matches the regular expression\r\n" + 
			"    against the whole text passed to the <code>Pattern.matcher()</code> method, when the <code>Matcher</code>\r\n" + 
			"    was created. Here is a <code>Matcher.matches()</code> example:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"String patternString = \".*http://.*\";\r\n" + 
			"Pattern pattern = Pattern.compile(patternString);\r\n" + 
			"\r\n" + 
			"<b>boolean matches = matcher.matches();</b>\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    If the regular expression matches the whole text, then the <code>matches()</code> method returns true.\r\n" + 
			"    If not, the <code>matches()</code> method returns false.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    You cannot use the <code>matches()</code> method to search for multiple occurrences of a regular\r\n" + 
			"    expression in a text. For that, you need to use the <code>find()</code>, <code>start()</code>\r\n" + 
			"    and <code>end()</code> methods.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<a name=\"lookingat-method\"></a>\r\n" + 
			"<h2>lookingAt()</h2>\r\n" + 
			"<p>\r\n" + 
			"    The <code>Matcher</code> <code>lookingAt()</code> method works like the <code>matches()</code> method with one major difference.\r\n" + 
			"    The <code>lookingAt()</code> method only matches the regular expression against the beginning of the text,\r\n" + 
			"    whereas <code>matches()</code> matches the regular expression against the whole text. In other words, if\r\n" + 
			"    the regular expression matches the beginning of a text but not the whole text, <code>lookingAt()</code>\r\n" + 
			"    will return true, whereas <code>matches()</code> will return false.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Here is a <code>Matcher.lookingAt()</code> example:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"import java.util.regex.Pattern;\r\n" + 
			"import java.util.regex.Matcher;\r\n" + 
			"\r\n" + 
			"public class CreateMatcherExample {\r\n" + 
			"\r\n" + 
			"    public static void main(String[] args) {\r\n" + 
			"\r\n" + 
			"        String text    =\r\n" + 
			"                \"This is the text to be searched \" +\r\n" + 
			"                \"for occurrences of the http:// pattern.\";\r\n" + 
			"\r\n" + 
			"        String patternString = \"This is the\";\r\n" + 
			"\r\n" + 
			"        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);\r\n" + 
			"        Matcher matcher = pattern.matcher(text);\r\n" + 
			"\r\n" + 
			"        System.out.println(\"lookingAt = \" + matcher.lookingAt());\r\n" + 
			"        System.out.println(\"matches   = \" + matcher.matches());\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    This example matches the regular expression <code>\"this is the\"</code> against both the beginning\r\n" + 
			"    of the text, and against the whole text. Matching the regular expression against the beginning\r\n" + 
			"    of the text (<code>lookingAt()</code>) will return true.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Matching the regular expression against\r\n" + 
			"    the whole text (<code>matches()</code>) will return false, because the text has more characters\r\n" + 
			"    than the regular expression. The regular expression says that the text must match the text\r\n" + 
			"    <code>\"This is the\"</code> exactly, with no extra characters before or after the expression.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<a name=\"find-start-end-methods\"></a>\r\n" + 
			"<h2>find() + start() + end()</h2>\r\n" + 
			"<p>\r\n" + 
			"    The <code>Matcher</code> <code>find()</code> method searches for occurrences of the regular expressions in the text\r\n" + 
			"    passed to the <code>Pattern.matcher(text)</code> method, when the <code>Matcher</code> was created.\r\n" + 
			"    If multiple matches can be found in the text, the <code>find()</code> method will find the first,\r\n" + 
			"    and then for each subsequent call to <code>find()</code> it will move to the next match.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    The methods <code>start()</code> and <code>end()</code> will give the indexes into the text where\r\n" + 
			"    the found match starts and ends. Actually <code>end()</code> returns the index of the character\r\n" + 
			"    <i>just after</i> the end of the matching section. Thus, you can use the return values of\r\n" + 
			"    <code>start()</code> and <code>end()</code> inside a <code>String.substring()</code> call.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Here is a Java <code>Matcher</code> <code>find()</code>, <code>start()</code> and <code>end()</code> example:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"import java.util.regex.Pattern;\r\n" + 
			"import java.util.regex.Matcher;\r\n" + 
			"\r\n" + 
			"public class MatcherFindStartEndExample {\r\n" + 
			"\r\n" + 
			"    public static void main(String[] args) {\r\n" + 
			"\r\n" + 
			"        String text    =\r\n" + 
			"                \"This is the text which is to be searched \" +\r\n" + 
			"                \"for occurrences of the word 'is'.\";\r\n" + 
			"\r\n" + 
			"        String patternString = \"is\";\r\n" + 
			"\r\n" + 
			"        Pattern pattern = Pattern.compile(patternString);\r\n" + 
			"        Matcher matcher = pattern.matcher(text);\r\n" + 
			"\r\n" + 
			"        int count = 0;\r\n" + 
			"        while(matcher.find()) {\r\n" + 
			"            count++;\r\n" + 
			"            System.out.println(\"found: \" + count + \" : \"\r\n" + 
			"                    + matcher.start() + \" - \" + matcher.end());\r\n" + 
			"        }\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    This example will find the pattern \"is\" four times in the searched string.\r\n" + 
			"    The output printed will be this:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"found: 1 : 2 - 4\r\n" + 
			"found: 2 : 5 - 7\r\n" + 
			"found: 3 : 23 - 25\r\n" + 
			"found: 4 : 70 - 72\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<a name=\"reset-method\"></a>\r\n" + 
			"<h2>reset()</h2>\r\n" + 
			"<p>\r\n" + 
			"    The <code>Matcher</code> <code>reset()</code> method resets the matching state internally in the <code>Matcher</code>.\r\n" + 
			"    In case you have started matching occurrences in a string via the <code>find()</code> method,\r\n" + 
			"    the <code>Matcher</code> will internally keep a state about how far it has searched through\r\n" + 
			"    the input text. By calling <code>reset()</code> the matching will start from the beginning\r\n" + 
			"    of the text again.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    There is also a <code>reset(CharSequence)</code> method. This method resets the <code>Matcher</code>,\r\n" + 
			"    and makes the <code>Matcher</code> search through the <code>CharSequence</code> passed as parameter,\r\n" + 
			"    instead of the <code>CharSequence</code> the <code>Matcher</code> was originally created with.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<a name=\"group-method\"></a>\r\n" + 
			"<h2>group()</h2>\r\n" + 
			"<p>\r\n" + 
			"    Imagine you are searching through a text for URL's, and you would like to extract the found URL's\r\n" + 
			"    out of the text. Of course you could do this with the <code>start()</code> and <code>end()</code>\r\n" + 
			"    methods, but it is easier to do so with the group functions.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Groups are marked with parentheses in the regular expression. For instance:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"(John)\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    This regular expression matches the text <code>John</code>. The parentheses are not part of the\r\n" + 
			"    text that is matched. The parentheses mark a group. When a match is found in a text, you can get\r\n" + 
			"    access to the part of the regular expression inside the group.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    You access a group using the <code>group(int groupNo)</code> method. A regular expression can\r\n" + 
			"    have more than one group. Each group is thus marked with a separate set of parentheses.\r\n" + 
			"    To get access to the text that matched the subpart of the expression in a specific group,\r\n" + 
			"    pass the number of the group to the <code>group(int groupNo)</code> method.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    The group with number 0 is always the whole regular expression. To get access to a group marked by parentheses\r\n" + 
			"    you should start with group numbers 1.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Here is a <code>Matcher</code> <code>group()</code> example:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"import java.util.regex.Pattern;\r\n" + 
			"import java.util.regex.Matcher;\r\n" + 
			"\r\n" + 
			"public class MatcherGroupExample {\r\n" + 
			"\r\n" + 
			"    public static void main(String[] args) {\r\n" + 
			"\r\n" + 
			"        String text    =\r\n" + 
			"                  \"John writes about this, and John writes about that,\" +\r\n" + 
			"                          \" and John writes about everything. \"\r\n" + 
			"                ;\r\n" + 
			"\r\n" + 
			"        String patternString1 = \"(John)\";\r\n" + 
			"\r\n" + 
			"        Pattern pattern = Pattern.compile(patternString1);\r\n" + 
			"        Matcher matcher = pattern.matcher(text);\r\n" + 
			"\r\n" + 
			"        while(matcher.find()) {\r\n" + 
			"            System.out.println(\"found: \" + matcher.group(1));\r\n" + 
			"        }\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    This example searches the text for occurrences of the word <code>John</code>.\r\n" + 
			"    For each match found, group number 1 is extracted, which is what matched\r\n" + 
			"    the group marked with parentheses. The output of the example is:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"found: John\r\n" + 
			"found: John\r\n" + 
			"found: John\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<a name=\"multiple-groups\"></a>\r\n" + 
			"<h3>Multiple Groups</h3>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    As mentioned earlier, a regular expression can have multiple groups. Here is a regular\r\n" + 
			"    expression illustrating that:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"(John) (.+?)\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    This expression matches the text <code>\"John\"</code> followed by a space, and\r\n" + 
			"    then one or more characters. You cannot see it in the example above, but there\r\n" + 
			"    is a space after the last group too.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    This expression contains a few characters with special meanings in a regular expression.\r\n" + 
			"    The . means \"any character\". The + means\r\n" + 
			"    \"one or more times\", and relates to the . (any character, one or more times).\r\n" + 
			"    The ? means \"match as small a number of characters as possible\".\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Here is a full code example:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"import java.util.regex.Pattern;\r\n" + 
			"import java.util.regex.Matcher;\r\n" + 
			"\r\n" + 
			"public class MatcherGroupExample {\r\n" + 
			"\r\n" + 
			"    public static void main(String[] args) {\r\n" + 
			"\r\n" + 
			"        String text    =\r\n" + 
			"                  \"John writes about this, and John Doe writes about that,\" +\r\n" + 
			"                          \" and John Wayne writes about everything.\"\r\n" + 
			"                ;\r\n" + 
			"\r\n" + 
			"        String patternString1 = \"(John) (.+?) \";\r\n" + 
			"\r\n" + 
			"        Pattern pattern = Pattern.compile(patternString1);\r\n" + 
			"        Matcher matcher = pattern.matcher(text);\r\n" + 
			"\r\n" + 
			"        while(matcher.find()) {\r\n" + 
			"            System.out.println(\"found: \" + <b>matcher.group(1)</b> +\r\n" + 
			"                               \" \"       + <b>matcher.group(2))</b>;\r\n" + 
			"        }\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Notice the reference to the two groups, marked in bold. The characters matched by those\r\n" + 
			"    groups are printed to <code>System.out</code>. Here is what the example prints out:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"found: John writes\r\n" + 
			"found: John Doe\r\n" + 
			"found: John Wayne\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<a name=\"groups-inside-groups\"></a>\r\n" + 
			"<h3>Groups Inside Groups</h3>\r\n" + 
			"<p>\r\n" + 
			"    It is possible to have groups inside groups in a regular expression. Here is an example:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"((John) (.+?))\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Notice how the two groups from the examples earlier are now nested inside a larger group.\r\n" + 
			"    (again, you cannot see the space at the end of the expression, but it is there).\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    When groups are nested inside each other, they are numbered based on when the left\r\n" + 
			"    paranthesis of the group is met. Thus, group 1 is the big group. Group 2 is the group\r\n" + 
			"    with the expression <code>John</code> inside. Group 3 is the group with the expression\r\n" + 
			"    <code>.+?</code> inside. This is important to know when you need to reference the\r\n" + 
			"    groups via the <code>groups(int groupNo)</code> method.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Here is an example that uses the above nested groups:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"import java.util.regex.Pattern;\r\n" + 
			"import java.util.regex.Matcher;\r\n" + 
			"\r\n" + 
			"public class MatcherGroupsExample {\r\n" + 
			"\r\n" + 
			"    public static void main(String[] args) {\r\n" + 
			"\r\n" + 
			"        String text    =\r\n" + 
			"                  \"John writes about this, and John Doe writes about that,\" +\r\n" + 
			"                          \" and John Wayne writes about everything.\"\r\n" + 
			"                ;\r\n" + 
			"\r\n" + 
			"        String patternString1 = \"((John) (.+?)) \";\r\n" + 
			"\r\n" + 
			"        Pattern pattern = Pattern.compile(patternString1);\r\n" + 
			"        Matcher matcher = pattern.matcher(text);\r\n" + 
			"\r\n" + 
			"        while(matcher.find()) {\r\n" + 
			"            System.out.println(\"found: <\"  + matcher.group(1) +\r\n" + 
			"                               \"> <\"       + matcher.group(2) +\r\n" + 
			"                               \"> <\"       + matcher.group(3) + \">\");\r\n" + 
			"        }\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Here is the output from the above example:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"found: &lt;John writes&gt; &lt;John&gt; &lt;writes&gt;\r\n" + 
			"found: &lt;John Doe&gt; &lt;John&gt; &lt;Doe&gt;\r\n" + 
			"found: &lt;John Wayne&gt; &lt;John&gt; &lt;Wayne&gt;\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Notice how the value matched by the first group (the outer group) contains the values matched\r\n" + 
			"    by both of the inner groups.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<a name=\"replaceall-replacefirst-methods\"></a>\r\n" + 
			"<h2>replaceAll() + replaceFirst()</h2>\r\n" + 
			"<p>\r\n" + 
			"    The <code>Matcher</code> <code>replaceAll()</code> and <code>replaceFirst()</code> methods can be used to replace\r\n" + 
			"    parts of the string the <code>Matcher</code> is searching through. The <code>replaceAll()</code>\r\n" + 
			"    method replaces all matches of the regular expression. The <code>replaceFirst()</code> only\r\n" + 
			"    replaces the first match.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Before any matching is carried out, the <code>Matcher</code> is reset, so that matching\r\n" + 
			"    starts from the beginning of the input text.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Here are two examples:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"import java.util.regex.Pattern;\r\n" + 
			"import java.util.regex.Matcher;\r\n" + 
			"\r\n" + 
			"public class MatcherReplaceExample {\r\n" + 
			"\r\n" + 
			"    public static void main(String[] args) {\r\n" + 
			"\r\n" + 
			"        String text    =\r\n" + 
			"                  \"John writes about this, and John Doe writes about that,\" +\r\n" + 
			"                          \" and John Wayne writes about everything.\"\r\n" + 
			"                ;\r\n" + 
			"\r\n" + 
			"        String patternString1 = \"((John) (.+?)) \";\r\n" + 
			"\r\n" + 
			"        Pattern pattern = Pattern.compile(patternString1);\r\n" + 
			"        Matcher matcher = pattern.matcher(text);\r\n" + 
			"\r\n" + 
			"        String replaceAll = matcher.replaceAll(\"Joe Blocks \");\r\n" + 
			"        System.out.println(\"replaceAll   = \" + replaceAll);\r\n" + 
			"\r\n" + 
			"        String replaceFirst = matcher.replaceFirst(\"Joe Blocks \");\r\n" + 
			"        System.out.println(\"replaceFirst = \" + replaceFirst);\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    And here is what the example outputs:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"replaceAll   = Joe Blocks about this, and Joe Blocks writes about that,\r\n" + 
			"    and Joe Blocks writes about everything.\r\n" + 
			"replaceFirst = Joe Blocks about this, and John Doe writes about that,\r\n" + 
			"    and John Wayne writes about everything.\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    The line breaks and indendation of the following line is not really part of the\r\n" + 
			"    output. I added them to make the output easier to read.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Notice how the first string printed has all occurrences of <code>John</code>\r\n" + 
			"    with a word after, replaced with the string <code>Joe Blocks</code>. The\r\n" + 
			"    second string only has the first occurrence replaced.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<a name=\"appendreplacement-appendtail-methods\"></a>\r\n" + 
			"<h2>appendReplacement() + appendTail()</h2>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    The <code>Matcher</code> <code>appendReplacement()</code> and <code>appendTail()</code> methods are used to replace\r\n" + 
			"    string tokens in an input text, and append the resulting string to a <code>StringBuffer</code>.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    When you have found a match using the <code>find()</code> method, you can call the\r\n" + 
			"    <code>appendReplacement()</code>. Doing so results in the characters from the input\r\n" + 
			"    text being appended to the <code>StringBuffer</code>, and the matched text being\r\n" + 
			"    replaced. Only the characters starting from then end of the last match, and until\r\n" + 
			"    just before the matched characters are copied.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    The <code>appendReplacement()</code> method keeps track of what has been copied into the\r\n" + 
			"    <code>StringBuffer</code>, so you can continue searching for matches using <code>find()</code>\r\n" + 
			"    until no more matches are found in the input text.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Once the last match has been found, a part of the input text will still not have been\r\n" + 
			"    copied into the <code>StringBuffer</code>. This is the characters from the end of\r\n" + 
			"    the last match and until the end of the input text. By calling <code>appendTail()</code>\r\n" + 
			"    you can append these last characters to the <code>StringBuffer</code> too.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Here is an example:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"import java.util.regex.Pattern;\r\n" + 
			"import java.util.regex.Matcher;\r\n" + 
			"\r\n" + 
			"public class MatcherReplaceExample {\r\n" + 
			"\r\n" + 
			"    public static void main(String[] args) {\r\n" + 
			"\r\n" + 
			"        String text    =\r\n" + 
			"                  \"John writes about this, and John Doe writes about that,\" +\r\n" + 
			"                          \" and John Wayne writes about everything.\"\r\n" + 
			"                ;\r\n" + 
			"\r\n" + 
			"        String patternString1 = \"((John) (.+?)) \";\r\n" + 
			"\r\n" + 
			"        Pattern      pattern      = Pattern.compile(patternString1);\r\n" + 
			"        Matcher      matcher      = pattern.matcher(text);\r\n" + 
			"        StringBuffer stringBuffer = new StringBuffer();\r\n" + 
			"\r\n" + 
			"        while(matcher.find()){\r\n" + 
			"            matcher.appendReplacement(stringBuffer, \"Joe Blocks \");\r\n" + 
			"            System.out.println(stringBuffer.toString());\r\n" + 
			"        }\r\n" + 
			"        matcher.appendTail(stringBuffer);\r\n" + 
			"\r\n" + 
			"        System.out.println(stringBuffer.toString());\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    Notice how <code>appendReplacement()</code> is called inside the <code>while(matcher.find())</code> loop,\r\n" + 
			"    and <code>appendTail()</code> is called just after the loop.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    The output from this example is:\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<pre class=\"codeBox\">\r\n" + 
			"Joe Blocks\r\n" + 
			"Joe Blocks about this, and Joe Blocks\r\n" + 
			"Joe Blocks about this, and Joe Blocks writes about that, and Joe Blocks\r\n" + 
			"Joe Blocks about this, and Joe Blocks writes about that, and Joe Blocks\r\n" + 
			"    writes about everything.\r\n" + 
			"</pre>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    The line break in the last line is inserted by me, to make the text more readable.\r\n" + 
			"    In the real output there would be no line break.\r\n" + 
			"</p>\r\n" + 
			"\r\n" + 
			"<p>\r\n" + 
			"    As you can see, the <code>StringBuffer</code> is built up by characters and replacements\r\n" + 
			"    from the input text, one match at a time.\r\n" + 
			"</p>\r\n" + 
			"            </div>\r\n" + 
			"\r\n" + 
			"            <div id=\"next\">Next: <a href=\"/java-regex/syntax.html\">Java Regex - Regular Expression Syntax</a></div>\r\n" + 
			"            <div id=\"bottomSocial\">\r\n" + 
			"\r\n" + 
			"                <div style=\"display:inline-block;\">\r\n" + 
			"                    <table>\r\n" + 
			"                        <tr><td colspan=\"2\">\r\n" + 
			"                            <div class='g-plus' data-action='share' data-height='24'  data-annotation='none'></div>\r\n" + 
			"                            <script type='text/javascript'>\r\n" + 
			"                                (function() {\r\n" + 
			"                                    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;\r\n" + 
			"                                    po.src = 'https://apis.google.com/js/platform.js';\r\n" + 
			"                                    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);\r\n" + 
			"                                 })();\r\n" + 
			"                            </script>\r\n" + 
			"\r\n" + 
			"                            <a href='https://twitter.com/share' class='twitter-share-button' data-via='jjenkov' target=\"_blank\">Tweet</a>\r\n" + 
			"                            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>\r\n" + 
			"\r\n" + 
			"                        </td></tr>\r\n" + 
			"                        <tr><td class=\"authorPhoto\"></td><td><p style=\"margin: 0px 0px 6px 0px;\">Jakob Jenkov</p><div class=\"authorSocialLinks\"></div></td></tr>\r\n" + 
			"                    </table>\r\n" + 
			"                </div>\r\n" + 
			"\r\n" + 
			"                <div  style=\"display: none;\" class=\"newsletterForm\"  style=\"display:inline-block;\"></div>\r\n" + 
			"\r\n" + 
			"            </div>\r\n" + 
			"\r\n" + 
			"        </div>\r\n" + 
			"    </div><div class=\"right\">\r\n" + 
			"        <div class=\"card cardRight cardTop cardBottom\">Right 1\r\n" + 
			"            <div>Right 2</div>\r\n" + 
			"        </div>\r\n" + 
			"    </div>\r\n" + 
			"    </div>\r\n" + 
			"    <div class=\"footer\">\r\n" + 
			"        <div id=\"footerCopyright\">Copyright Jenkov Aps</div>\r\n" + 
			"    </div>\r\n" + 
			"</div>\r\n" + 
			"\r\n" + 
			"<style>\r\n" + 
			".navButton{color: #ffffff; font-weight: bold;}\r\n" + 
			"#trailTocFixedDiv{position: fixed;  top : 0px; left : 0px; width : 100%; height : 100%;  display : none; background-color: #ffffff;}\r\n" + 
			"#trailTocFixedInnerDiv{width: 400px; max-width: 94%; height: calc(100% - 72px); overflow : auto; margin: 20px auto 20px auto; padding: 0px 0px 180px 0px;}\r\n" + 
			"#trailTocFixedInnerDiv th{border-bottom: 1px solid #f0f0f0;padding: 6px 10px;text-align: left;font-size: 1.2em;}\r\n" + 
			"#trailTocFixedInnerDiv td{border-bottom: 1px solid #f0f0f0;padding: 6px 20px;vertical-align: top;}\r\n" + 
			"#trailTocFixedCloseButton{width : 72px; padding: 10px 20px; background-color: #009900; border: 2px solid #006600; color: #ffffff; font-size: 0.8em; font-weight: bold; position: absolute; right: 0px; cursor: pointer; box-shadow: 2px 2px 2px 2px #cccccc;}\r\n" + 
			"#bottomNavBarDiv{position:fixed; bottom: 0px; width: 100%;  background-color: #202020; border-top: 1px solid #444444;}\r\n" + 
			".buttonNavBarButtonDivActive{background-color: #404040;}\r\n" + 
			"#bottomNavBarRow>div{border-left: 1px solid #404040; border-right: 1px solid #000000;  height: 48px;  padding-top:16px; text-align: center; cursor: pointer;}\r\n" + 
			"#bottomNavBarDiv a{color: #ffffff; font-weight: bold;}\r\n" + 
			"#bottomNavBarDiv br{display:none;}\r\n" + 
			"#bottomNavBarDiv img{ height: 20px; }\r\n" + 
			"#nextButton2{ display:none; }\r\n" + 
			"@media only screen and (max-width: 700px){\r\n" + 
			"  #bottomNavBarDiv, #bottomNavBarDiv [jqc-cell] { height: 58px; }\r\n" + 
			"  #bottomNavBarDiv [jqc-cell] {padding-top: 12px;}\r\n" + 
			"  #bottomNavBarDiv a { font-size: 0.8em; }\r\n" + 
			"  #bottomNavBarDiv br { display: inline; }\r\n" + 
			"  #nextButton1 { display: none; }\r\n" + 
			"  #nextButton2 { display: inline; }\r\n" + 
			"}\r\n" + 
			"@media only screen and (max-width: 400px){\r\n" + 
			"  #bottomNavBarDiv [jqc-cell] {padding-top: 10px;}\r\n" + 
			"  #bottomNavBarDiv a {font-size: 0.5em;}\r\n" + 
			"  #bottomNavBarDiv img {height: 24px;}\r\n" + 
			"}\r\n" + 
			"</style>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<div id=\"trailTocFixedDiv\">\r\n" + 
			"    <div id=\"trailTocFixedCloseButton\">Close TOC</div>\r\n" + 
			"    <div id=\"trailTocFixedInnerDiv\"></div>\r\n" + 
			"</div>\r\n" + 
			"\r\n" + 
			"<style>\r\n" + 
			"#bottomNavBar2Parent{position:fixed; bottom: 0px; width: 100%;  background-color: #202020; border-top: 1px solid #444444;}\r\n" + 
			"#bottomNavBar2>div{border-left: 1px solid #404040; border-right: 1px solid #000000;  height: 48px;  padding-top:16px; text-align: center; cursor: pointer;}\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"#bottomNavBar2{\r\n" + 
			"  display: grid;\r\n" + 
			"}\r\n" + 
			"#allTrailsButtonDiv2{\r\n" + 
			"  grid-column-start: 1;\r\n" + 
			"  grid-column-end: 3;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"#trailTocButtonDiv2 {\r\n" + 
			"  grid-column-start: 3;\r\n" + 
			"  grid-column-end: 5;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"#pageTocButtonDiv2{\r\n" + 
			"  grid-column-start: 5;\r\n" + 
			"  grid-column-end: 7;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"#prevButtonDiv2 {\r\n" + 
			"  grid-column-start: 7;\r\n" + 
			"  grid-column-end: 9;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"#nextButtonDiv2 {\r\n" + 
			"  grid-column-start: 9;\r\n" + 
			"  grid-column-end: 13;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"</style>\r\n" + 
			"\r\n" + 
			"<div id=\"bottomNavBar2Parent\">\r\n" + 
			"<div id=\"bottomNavBar2\">\r\n" + 
			"\r\n" + 
			"    <div id=\"allTrailsButtonDiv2\">\r\n" + 
			"        <span><img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAbUlEQVRIx+3SQQrAIAxEUenNewrvmkXUQgVJEwWdQEED4kb+QzSEPw0z389yi6d3JJKaWY5ryBKgxSVS9jgF9OItQkRXRaBxDYHHJeISt34XND5EEHETQcY/iEfcvAkqbD7yAaYB1PkD7AB4TAY0StbUr69awQAAAABJRU5ErkJggg==\" ></span> <br>\r\n" + 
			"        <span class=\"navButton\" style=\"position:relative; top:-4px;\">All Trails</span>\r\n" + 
			"    </div>\r\n" + 
			"\r\n" + 
			"    <div id=\"trailTocButtonDiv2\">\r\n" + 
			"        <span><img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAPElEQVRIx2P4TwPAgAzoZgEDrQDdLaB6cI1aMHgtoFriGRkWEB3eg9YHo0E08BaM8CAiWoLaFlAL0NwCANELs4XjmhvVAAAAAElFTkSuQmCC\"></span> <br>\r\n" + 
			"        <span class=\"navButton\" style=\"position:relative; top:-4px;\">Trail TOC</span>\r\n" + 
			"    </div>\r\n" + 
			"\r\n" + 
			"    <div id=\"pageTocButtonDiv2\">\r\n" + 
			"        <span><img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAANUlEQVRIx2NggIL/VAYM6GDUglELqGcBA4Vg1ALqWkBOhA4uH4wG0cBbMBpEw9QCagG6WQAAX980BcIgiscAAAAASUVORK5CYII=\" ></span> <br>\r\n" + 
			"        <span class=\"navButton\" style=\"position:relative; top:-4px;\">Page TOC</span>\r\n" + 
			"    </div>\r\n" + 
			"\r\n" + 
			"    <div id=\"prevButtonDiv2\">\r\n" + 
			"        <span><img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNvyMY98AAACCSURBVEhL3ZRRCsAgDEM9iez+dxJPUl0K9W+MtKMiC/RL80Lz0eKViNQxRpsvwnvHv8ssvGD8ORzjh7Odf4F34zxK30O1qImEV7Pw0nUJeEuFY/xwspZceKiWVLgqPUC1JQSAc0Iwh2+iZiIkdiqWdobknOslmM8JwcbxELaujSGl3GNH6mWcCMu2AAAAAElFTkSuQmCC\"></span> <br>\r\n" + 
			"        <span class=\"navButton\" style=\"position:relative; top:-4px;\">Previous</span>\r\n" + 
			"    </div>\r\n" + 
			"\r\n" + 
			"    <div id=\"nextButtonDiv2\">\r\n" + 
			"        <!--<span class=\"navButton\" id=\"nextButton1_2\" style=\"position:relative; top:-4px;\">Next</span>-->\r\n" + 
			"        <span><img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAb0lEQVRIx82W2w1AIQhDmcS4/07GScDbu4AvUlMSv9QeA6RohnD3GhF9TAL7DeeK3cYuBEscgss6kBc16VlI2YTULKStIH9aMzXRgTxJlzaECpAQv+okaptSX35gFed+RBWn2jV14FBHJvVnwRT/AGJL6mWb6M7pAAAAAElFTkSuQmCC\" ></span> <br>\r\n" + 
			"        <span class=\"navButton\" id=\"nextButton2_2\" style=\"position:relative; top:-4px;\">Next</span>\r\n" + 
			"    </div>\r\n" + 
			"\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<script>\r\n" + 
			"var prevArticleInCategory = \"/java-regex/pattern.html\";\r\n" + 
			"var nextArticleInCategory = \"/java-regex/syntax.html\";\r\n" + 
			"</script>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<script>\r\n" + 
			"function qid(id) { return document.getElementById(id); }\r\n" + 
			"</script>\r\n" + 
			"\r\n" + 
			"<!-- Nav bar code -->\r\n" + 
			"<script>\r\n" + 
			"function toggle(el){\r\n" + 
			"    if(el.isShown == null || el.isShown == false) {\r\n" + 
			"        el.isShown = true;\r\n" + 
			"        el.style.display = \"block\";\r\n" + 
			"    } else {\r\n" + 
			"        el.isShown = false;\r\n" + 
			"        el.style.display = \"none\";\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"qid(\"allTrailsButtonDiv2\").addEventListener(\"mouseup\", function(e) {\r\n" + 
			"    location.href=\"/\";\r\n" + 
			"    e.preventDefault();\r\n" + 
			"    e.stopPropagation();\r\n" + 
			"});\r\n" + 
			"qid(\"trailTocButtonDiv2\").addEventListener(\"mouseup\", function(e) {\r\n" + 
			"    var tocHtml = qid(\"trailToc\").innerHTML;\r\n" + 
			"    qid(\"trailTocFixedInnerDiv\").innerHTML = tocHtml + \"<br><br><br><br><br><br><br><br><br><br>\";\r\n" + 
			"    toggle(qid(\"trailTocFixedDiv\"));\r\n" + 
			"    e.preventDefault();\r\n" + 
			"    e.stopPropagation();\r\n" + 
			"});\r\n" + 
			"qid(\"trailTocFixedCloseButton\").addEventListener(\"mouseup\", function(e) {\r\n" + 
			"    toggle(qid(\"trailTocFixedDiv\"));\r\n" + 
			"    e.preventDefault();\r\n" + 
			"    e.stopPropagation();\r\n" + 
			"});\r\n" + 
			"qid(\"pageTocButtonDiv2\").addEventListener(\"mouseup\", function(e) {\r\n" + 
			"    location.href=\"#pageToc\";\r\n" + 
			"    e.preventDefault();\r\n" + 
			"    e.stopPropagation();\r\n" + 
			"});\r\n" + 
			"qid(\"prevButtonDiv2\").addEventListener(\"mouseup\", function(e) {\r\n" + 
			"    if(prevArticleInCategory != \"\") {\r\n" + 
			"        location.href = prevArticleInCategory;\r\n" + 
			"    } else {\r\n" + 
			"        alert(\"This is the first article in this trail\");\r\n" + 
			"    }\r\n" + 
			"});\r\n" + 
			"qid(\"nextButtonDiv2\").addEventListener(\"mouseup\", function(e) {\r\n" + 
			"  if(nextArticleInCategory != \"\") {\r\n" + 
			"    location.href= nextArticleInCategory;\r\n" + 
			"  } else {\r\n" + 
			"    alert(\"This is the last article in this trail.\");\r\n" + 
			"  }\r\n" + 
			"  e.preventDefault();\r\n" + 
			"  e.stopPropagation();\r\n" + 
			"});\r\n" + 
			"</script>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<!-- Google Analytics Script -->\r\n" + 
			"<script>\r\n" + 
			"  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\r\n" + 
			"  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\r\n" + 
			"  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\r\n" + 
			"  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\r\n" + 
			"\r\n" + 
			"  ga('create', 'UA-4036229-3', 'auto');\r\n" + 
			"  ga('send', 'pageview');\r\n" + 
			"</script>\r\n" + 
			"\r\n" + 
			"<!-- Google Adsense Script -->\r\n" + 
			"<script data-ad-client=\"ca-pub-5569543489255665\" async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"</body>\r\n" + 
			"</html>\r\n";
	
	String website3 = "<html>\r\n" + 
			"    <style>\r\n" + 
			"        /* for demonstration */\r\n" + 
			"        .gallery { height: 100px; background-color: #CCC;  }\r\n" + 
			"        .content { height: 200px; background-color: #EEE; }\r\n" + 
			"        .sidebar { height: 200px; background-color: #AAA; }\r\n" + 
			"        /* common */\r\n" + 
			"        .middle { display: flex; flex-direction: row; flex-wrap: wrap; }\r\n" + 
			"        /* layout-1 */\r\n" + 
			"        .middle.layout-1 .gallery { order: 1; width: 100%; }\r\n" + 
			"        .middle.layout-1 .content { order: 3; width:  75%; }\r\n" + 
			"        .middle.layout-1 .sidebar { order: 2; width:  25%; }\r\n" + 
			"        /* layout-2 */\r\n" + 
			"        .middle.layout-2 { position: relative; }\r\n" + 
			"        .middle.layout-2 .gallery { width: 75%; margin-left: 25%; }\r\n" + 
			"        .middle.layout-2 .content { width: 75%; margin-left: 25%; }\r\n" + 
			"        .middle.layout-2 .sidebar { position: absolute; top: 0; left: 0; width: 25%; height: 100%;}\r\n" + 
			"    </style>\r\n" + 
			"    <div class=\"middle layout-1\">\r\n" + 
			"        <div class=\"gallery\">Gallery</div>\r\n" + 
			"        <div class=\"content\">Content (this layout works perfectly)</div>\r\n" + 
			"        <div class=\"sidebar\">Sidebar</div>\r\n" + 
			"    </div>\r\n" + 
			"    <hr>\r\n" + 
			"    <div class=\"middle layout-2\">\r\n" + 
			"        <div class=\"gallery\">Gallery</div>\r\n" + 
			"        <div class=\"content\">Content (should go below gallery)</div>\r\n" + 
			"        <div class=\"sidebar\">Sidebar</div>\r\n" + 
			"    </div>\r\n" + 
			"</html>";
	
	public List<String> getWebsite1CssList(){
		List<String> cssList = new ArrayList<String>();
		cssList.add(".middle { display: flex; flex-direction: row; flex-wrap: wrap; }");
		cssList.add(".middle.layout-1 .gallery { width:  100%; }");
		cssList.add(".middle.layout-1 .sidebar { width:  25%; }");
		cssList.add(".middle.layout-1 .content { width:  75%; }");
		return cssList;
	}

	public String getWebsite1() {
		return website1;
	}
	
	public String getWebsie2() {
		return website2;
	}
	
	public String getWebsite3() {
		return website3;
	}
	
	public String getWebsite4() {
		return websiteTest1;
	}
	
	public String cssFile = "@keyframes selectionSharerPopover-animation{0%{transform:matrix(0.97,0,0,1,0,12);filter:alpha(opacity=0);opacity:0}20%{transform:matrix(0.99,0,0,1,0,2);filter:alpha(opacity=70);opacity:.7}40%{transform:matrix(1,0,0,1,0,-1);filter:alpha(opacity=100);opacity:1}100%,70%{transform:matrix(1,0,0,1,0,0);filter:alpha(opacity=100);opacity:1}}#selectionSharerPopover{display:none;position:absolute;top:-100px;left:-100px;z-index:1010}#selectionSharerPopover:after{content:'';display:block;position:absolute;bottom:-3px;left:50%;margin-left:-4px;width:8px;height:8px;-webkit-transform:rotate(45deg);transform:rotate(45deg);background:#262625;box-shadow:0 0 2px #262625}#selectionSharerPopover.anim{transition:top .075s ease-out;animation:selectionSharerPopover-animation 180ms forwards linear;-webkit-animation:selectionSharerPopover-animation 180ms forwards linear}#selectionSharerPopover-inner{position:relative;overflow:hidden;-webkit-border-radius:5px;border-radius:5px;border:1px solid;border-color:#262625 #1c1c1b #121211;box-shadow:0 1px 3px -1px rgba(0,0,0,.7),inset 0 0 1px rgba(255,255,255,.07),inset 0 0 2px rgba(255,255,255,.15);background:linear-gradient(to bottom,rgba(49,49,47,.97),#262625);background-repeat:repeat-x}#selectionSharerPopover .selectionSharerPopover-clip{position:absolute;bottom:-11px;display:block;left:50%;clip:rect(12px 24px 24px 0);margin-left:-12px;width:24px;height:24px;line-height:24px}#selectionSharerPopover .selectionSharerPopover-arrow{display:block;width:20px;height:20px;-webkit-transform:rotate(45deg) scale(0.5);transform:rotate(45deg) scale(0.5);background-color:#454543;border:2px solid #121211;box-sizing:content-box}.selectionSharer ul{padding:0;display:inline}.selectionSharer ul li{float:left;list-style:none;background:0 0;margin:0}.selectionSharer a.action{display:block;text-indent:-200px;margin:5px 7px;width:20px;height:20px;border:none}.selectionSharer a:hover{color:#ccc}.selectionSharer a.tweet{background:url('data:image/svg+xml;utf8,<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"171\" height=\"139\"><g transform=\"translate(-282.32053,-396.30734)\"><path style=\"fill:white\" d=\"m 453.82593,412.80619 c -6.3097,2.79897 -13.09189,4.68982 -20.20852,5.54049 7.26413,-4.35454 12.84406,-11.24992 15.47067,-19.46675 -6.79934,4.03295 -14.3293,6.96055 -22.34461,8.53841 -6.41775,-6.83879 -15.56243,-11.111 -25.68298,-11.111 -19.43159,0 -35.18696,15.75365 -35.18696,35.18525 0,2.75781 0.31128,5.44359 0.91155,8.01875 -29.24344,-1.46723 -55.16995,-15.47582 -72.52461,-36.76396 -3.02879,5.19662 -4.76443,11.24048 -4.76443,17.6891 0,12.20777 6.21194,22.97747 15.65332,29.28716 -5.76773,-0.18265 -11.19331,-1.76565 -15.93716,-4.40083 -0.004,0.14663 -0.004,0.29412 -0.004,0.44248 0,17.04767 12.12889,31.26806 28.22555,34.50266 -2.95247,0.80436 -6.06101,1.23398 -9.26989,1.23398 -2.2673,0 -4.47114,-0.22124 -6.62011,-0.63114 4.47801,13.97857 17.47214,24.15143 32.86992,24.43441 -12.04227,9.43796 -27.21366,15.06335 -43.69965,15.06335 -2.84014,0 -5.64082,-0.16722 -8.39349,-0.49223 15.57186,9.98421 34.06703,15.8094 53.93768,15.8094 64.72024,0 100.11301,-53.61524 100.11301,-100.11387 0,-1.52554 -0.0343,-3.04251 -0.10204,-4.55261 6.87394,-4.95995 12.83891,-11.15646 17.55618,-18.21305 z\" /></g></svg>') 2px/18px no-repeat}.selectionSharer a.facebook{background:url('data:image/svg+xml;utf8,<svg viewBox=\"0 0 33 33\" width=\"25\" height=\"25\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><g><path style=\"fill:white\" d=\"M 17.996,32L 12,32 L 12,16 l-4,0 l0-5.514 l 4-0.002l-0.006-3.248C 11.993,2.737, 13.213,0, 18.512,0l 4.412,0 l0,5.515 l-2.757,0 c-2.063,0-2.163,0.77-2.163,2.209l-0.008,2.76l 4.959,0 l-0.585,5.514L 18,16L 17.996,32z\"></path></g></svg>') 0/18px no-repeat;display:none}.selectionSharer a.linkedin{background:url('data:image/svg+xml;utf8,<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\" width=\"300px\" height=\"300px\" viewBox=\"0 0 300 300\" enable-background=\"new 0 0 300 300\" xml:space=\"preserve\"><g transform=\"translate(0.000000,300.000000) scale(0.100000,-0.100000)\"><path fill=\"white\" d=\"M343.999,2812.002C222.998,2770,155,2672.002,155,2540c0-62.002,5-85,27.998-132.998 c108.003-219.004,459.004-206.001,560,21.997c16.001,36.001,18.003,60,15,125c-5,97.002-27.998,146.001-91.997,203.003 C586.001,2827.002,453.999,2850,343.999,2812.002z\"/> <path fill=\"white\" d=\"M2035.996,2052.998c-150.996-31.997-257.998-92.998-365-210l-68.994-75l-7.002,79.004 c-5,42.998-10.996,100.996-14.004,127.998l-5.996,50l-253.999,2.998L1067.998,2030l6.001-62.002c3.003-35,8.999-452.998,12.002-930 L1092.998,170h288.003H1670l2.002,597.998C1675,1365,1675,1365,1697.998,1410.996c34.004,70,87.002,125.005,150,156.006 c75,36.997,192.998,38.999,257.998,5c59.004-31.001,111.006-95,137.002-172.002c21.006-64.004,22.002-77.002,25-647.002 L2270.996,170h290h290l-3.994,642.998c-2.998,547.998-6.006,652.002-20,707.002c-42.998,172.998-97.002,280-187.998,371.001 C2494.004,2037.998,2257.002,2101.001,2035.996,2052.998z\"/><path fill=\"white\" d=\"M167.002,2022.998c-4.004-2.998-7.002-421.997-7.002-930V170h295h295l-2.002,927.998L745,2025 l-286.001,2.998C302.002,2028.999,171.001,2027.002,167.002,2022.998z\"/></g></svg>') 2px/18px no-repeat}.selectionSharer a.email{background:url('data:image/svg+xml;utf8,<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"94\" height=\"64\"><g transform=\"translate(-10, -10)\" fill=\"transparent\"><rect x=\"0\" y=\"0\" width=\"114\" height=\"114\"></rect><path d=\"M12,12 L102,12 L102,72 L12,72 L12,12 Z M16,12 L53,49 C55.6666667,51 58.3333333,51 61,49 L98,12 L16,12 Z M15,72 L45,42 L15,72 Z M69,42 L99,72 L69,42 Z\" stroke=\"white\" stroke-width=\"5\"></path></g></svg>') 0/20px no-repeat}#selectionSharerPopunder.fixed{transition:bottom .5s ease-in-out;width:100%;position:fixed;left:0;bottom:-50px}.selectionSharer{transition:-webkit-transform .6s ease-in-out}.selectionSharer.moveDown{-webkit-transform:translate3d(0,60px,0)}#selectionSharerPopunder{position:absolute;left:0;width:100%;height:0;transition:height .5s ease-in-out;background:#ccc;border:none;box-shadow:inset 0 10px 5px -10px rgba(0,0,0,.5),inset 0 -10px 5px -10px rgba(0,0,0,.5);border-radius:0;overflow:hidden}#selectionSharerPopunder.show{height:50px}.selectionSharerPlaceholder{height:1em;margin-bottom:-2em;transition:height .5s ease-in-out}.selectionSharerPlaceholder.show{height:50px!important}#selectionSharerPopunder-inner ul{overflow:hidden;float:right;margin:0}#selectionSharerPopunder-inner ul li{padding:5px 4px 5px 1px;overflow:hidden}#selectionSharerPopunder-inner label{color:#fff;font-weight:300;line-height:50px;margin:0 7px 0 10px}#selectionSharerPopunder-inner a{width:25px;height:25px;background-size:25px}#selectionSharerPopunder-inner a.tweet{background-position:0 2px}";
	
	public String getCssFile1() {
		return cssFile;
	}
}
