var Warp=Warp||{};Warp.Base={matchHeight:function(e,d){var c=0;$$(e).each(function(a){var b;if(a.offsetHeight)b=a.offsetHeight;else if(a.style.pixelHeight)b=a.style.pixelHeight;b||(b=0);c=Math.max(c,b)});if(d!=undefined)c=Math.max(c,d);$$(e).each(function(a){var b=a.getStyle("padding-top").toInt()+a.getStyle("padding-bottom").toInt()+a.getStyle("border-top-width").toInt()+a.getStyle("border-bottom-width").toInt();a.setStyle(window.ie6?"height":"min-height",c-b+"px")})}};Warp.Morph=new Class({initialize:function(e,d,c,a,b,k){this.setOptions({duration:500,transition:Fx.Transitions.expoOut,wait:false,ignore:""},a);var f=this.options,i=null;if($chk(f.ignore))i=$$(f.ignore);$$(e).each(function(g){if(!(i&&i.contains(g))){var j=[],l=[g];if(k)l=g.getElementsBySelector(k);l.each(function(h,m){j[m]=new Fx.Styles(h,f)});g.addEvent("mouseenter",function(){j.each(function(h){h.setOptions(f,a).start(d)})});g.addEvent("mouseleave",function(){j.each(function(h){h.setOptions(f,b).start(c)})})}})}});Warp.Morph.implement(new Options);Warp.BackgroundFx=new Class({initialize:function(e){function d(){c.start({"background-color":b[a]});if(a+1>=b.length)a=0;else a++}this.setOptions({transition:Fx.Transitions.linear,duration:9E3,wait:false,colors:["#FFFFFF","#999999"]},e);var c=(new Element(document.body)).effects(this.options),a=0,b=this.options.colors;d.periodical(this.options.duration*2);d()}});Warp.BackgroundFx.implement(new Options);var Warp=Warp||{};Warp.AccordionMenu=new Class({initialize:function(a,c,d){this.setOptions({accordion:"default",onActive:function(b){b.addClass("active");b.getFirst().addClass("active")},onBackground:function(b){b.removeClass("active");b.getFirst().removeClass("active")}},d);this.togs=a;this.elms=c;switch(this.options.accordion){case"slide":this.createSlide();break;default:this.createDefault()}},createDefault:function(){var a={};if(!$defined(this.options.display)&&!$defined(this.options.show))a={show:-1};$ES(this.togs).each(function(c,d){if(c.hasClass("active"))a={show:d}}.bind(this));new Fx.Accordion(this.togs,this.elms,$extend(this.options,a))},createSlide:function(){$ES(this.togs).each(function(a,c){var d=a.getElement("span"),b=a.getElement(this.elms),e=new Fx.Slide(b,{transition:Fx.Transitions.linear,duration:250});a.hasClass("active")||this.options.display=="all"||this.options.display==c||e.hide();d.addEvent("click",function(){e.toggle().chain(function(){a.toggleClass("active");a.getFirst().toggleClass("active")})})}.bind(this))}});Warp.AccordionMenu.implement(new Options);var Warp=Warp||{};Warp.Menu=new Class({initialize:function(d,c){this.setOptions({mode:"default",itemSelector:"li",dropdownSelector:"ul",duration:600,remainTime:800,remainClass:"remain",firstLevelSelector:"li.level1",transition:Fx.Transitions.linear,wait:false},c);var a=this;this.menu=$(d);this.hovered=this.timer=null;this.dropdowns=[];this.remain=[];if(this.menu){this.firstLevelItems=this.menu.getElements(this.options.firstLevelSelector);this.menu.addEvents({mouseenter:function(){a.remain=[];a.removeRemain(10,true)},mouseleave:function(){a.remain.each(function(b){b.addClass(a.options.remainClass)});a.removeRemain(a.options.remainTime);a.menu.getElement("li."+a.options.remainClass)||a.fireMenuEvent("menu:leave")}});this.firstLevelItems.addEvent("mouseenter",function(){if(!this.hasClass(a.options.remainClass)){a.fireMenuEvent("menu:leave");a.fireMenuEvent("menu:enter",this)}});this.menu.getElements(this.options.itemSelector).each(function(b){var e=b.getElement(this.options.dropdownSelector);if(e){this.dropdowns.include(b);this.options.mode=="slide"?this.attachSlideFx(b,e):this.attachDefaultFx(b,e);b.addEvents({mouseenter:function(){b._dropdownhover=true;a.remain=[];!b.hasClass(a.options.remainClass)&&!window.opera&&b.fireEvent("fx:dropdown")},mouseleave:function(f){b._dropdownhover=false;a.menu!=f.relatedTarget&&!a.menu.hasChild(f.relatedTarget)&&a.remain.include(b)}})}}.bind(this));this.options.fancy&&Warp.FancyMenu&&new Warp.FancyMenu(this.menu,$extend({hoverClass:a.options.hoverClass},a.options.fancy))}},fireMenuEvent:function(d,c){if(d=="menu:leave"){if(!this.hovered)return;c=this.hovered}else this.hovered=c;for(var a=0,b=0;b<this.firstLevelItems.length;b++)if(c==this.firstLevelItems[b]){a=b;break}this.menu.fireEvent(d,[c,a])},attachDefaultFx:function(d,c){var a=c.getStyles("width","height","opacity"),b={width:0,height:0};(new Element("div")).adopt(c.getChildren()).injectInside(c).setStyle("width",a.width.toInt());var e=new Fx.Styles(c,this.options);switch(this.options.mode){case"width":b={width:0};break;case"height":b={height:0}}d.addEvent("fx:dropdown",function(){e.stop();e.element.setStyles($extend(b,window.ie?{overflow:"hidden"}:{opacity:0,overflow:"hidden"}));e.start(a).chain(function(){e.element.setStyles(a)})})},attachSlideFx:function(d,c){var a=c.getStyles("width","height","opacity"),b=(new Element("div")).adopt(c.getChildren()).injectInside(c),e=new Fx.Styles(c,this.options),f=new Fx.Styles(b,this.options);d.addEvent("fx:dropdown",function(){e.stop();e.element.setStyles({height:0,overflow:"hidden"});e.start(a).chain(function(){e.element.setStyles(a)});f.stop();f.element.setStyles({"margin-top":-a.height.toInt()});f.start({"margin-top":0})})},removeRemain:function(d,c){$clear(this.timer);this.timer=function(){this.dropdowns.each(function(a){if(a.hasClass(this.options.remainClass)&&!a._dropdownhover)c||c||this.fireMenuEvent("menu:leave");a.removeClass(this.options.remainClass)}.bind(this))}.delay(d,this)},matchHeight:function(){this.menu&&this.menu.getElements("li.level2 div.sub").each(function(d){var c=d.getParent().getElement("div.hover-box4"),a=Math.max(d.getCoordinates().height,c.getCoordinates().height);[d,c].each(function(b){var e=b.getStyle("padding-top").toInt()+b.getStyle("padding-bottom").toInt()+b.getStyle("border-top-width").toInt()+b.getStyle("border-bottom-width").toInt();b.setStyle("height",a-e)})})},matchUlHeight:function(){this.menu&&this.menu.getElements("div.dropdown-3").each(function(d){d=d.getChildren();var c=0;d.each(function(a){c=Math.max(a.getCoordinates().height,c)});d.each(function(a){var b=a.getStyle("padding-top").toInt()+
a.getStyle("padding-bottom").toInt()+a.getStyle("border-top-width").toInt()+a.getStyle("border-bottom-width").toInt();a.setStyle("height",c-b)})})}});Warp.Menu.implement(new Events,new Options);var Warp=Warp||{};Warp.FancyMenu=new Class({initialize:function(a,b){this.setOptions({transition:Fx.Transitions.sineInOut,duration:500,wait:false,onClick:Class.empty,onEnterItem:Class.empty,onLeaveItem:Class.empty,opacity:1,mode:"move",slideOffset:30,itemSelector:"li.level1",activeSelector:"li.active",dropdownSelector:"div.dropdown"},b);var c=0;this.menu=$(a);this.items=[];this.div=[];if(this.menu){this.current=this.menu.getElement(this.options.activeSelector);var f=this;this.menu.getElements(this.options.itemSelector).each(function(d,e){d.addEvent("click",function(h){this.clickItem(h,d)}.bind(this));this.options.mode!="move"&&this.createBackground(e,e+1);if(this.options.mode=="move"&&this.current==d)c=e}.bind(this));this.menu.addEvent("menu:enter",function(d,e){f.mouseenterItem(d,e)});this.menu.addEvent("menu:leave",function(d,e){f.mouseleaveItem(d,e)});if(this.options.mode=="move"){this.createBackground(0,c+1);if(this.current)this.setCurrent(this.current);else{var g=this.menu.getElement("li");g.addClass("active");g.addClass("current");this.setCurrent(g)}}}},createBackground:function(a,b){var c="fancy bg"+b;this.div[a]=(new Element("div",{"class":"fancy-1"})).adopt((new Element("div",{"class":"fancy-2"})).adopt(new Element("div",{"class":"fancy-3"})));this.div[a].fx=this.div[a].effects(this.options);this.items[a]=(new Element("div",{"class":c})).adopt(this.div[a]).injectInside(this.menu);this.items[a].fx=this.items[a].effects(this.options)},setCurrent:function(a){this.items[0].setStyles({left:a.offsetLeft,width:a.offsetWidth,visibility:"visible",opacity:this.options.opacity});this.current=a},clickItem:function(a,b){this.current||this.setCurrent(b);this.current=b;this.options.onClick(new Event(a),b)},mouseenterItem:function(a,b){if(!a._fancyactive){a._fancyactive=true;switch(this.options.mode){case"fade":this.fadeFx(a,b,true);break;case"slide":this.slideFx(a,b,true);break;default:this.moveFx(a,0)}this.fireEvent("onEnterItem",[a,b])}},mouseleaveItem:function(a,b){a._fancyactive=false;switch(this.options.mode){case"fade":this.fadeFx(a,b,false);break;case"slide":this.slideFx(a,b,false);break;default:this.moveFx(this.current,0)}this.fireEvent("onLeaveItem",[a,b])},moveFx:function(a,b){this.current&&this.items[b].fx.custom({left:[this.items[b].offsetLeft,a.offsetLeft],width:[this.items[b].offsetWidth,a.offsetWidth]})},fadeFx:function(a,b,c){if(c){this.items[b].fx.setOptions(this.options);this.items[b].fx.set({left:a.offsetLeft,width:a.offsetWidth});this.items[b].fx.custom({opacity:[0,1]})}else{this.items[b].fx.setOptions({duration:this.options.duration*2});this.items[b].fx.custom({opacity:[1,0]})}},slideFx:function(a,b,c){var f=this.options.slideOffset;if(c){this.items[b].fx.set({opacity:1,left:a.offsetLeft,width:a.offsetWidth});this.div[b].fx.set({"margin-top":f});this.div[b].fx.custom({"margin-top":[f,0]})}else{this.div[b].fx.set({"margin-top":0});this.div[b].fx.custom({"margin-top":[0,f]})}}});Warp.FancyMenu.implement(new Events,new Options);var WarpTemplate={start:function(){new Warp.AccordionMenu('div#middle ul.menu li.toggler','ul.accordion',{accordion:'slide'});var dropdown=new Warp.Menu('menu',{mode:'height',duration:300,dropdownSelector:'div.dropdown',transition:Fx.Transitions.Expo.easeOut,fancy:{mode:'fade',transition:Fx.Transitions.Back.easeOut,duration:300}});switch(Warp.Settings.color){case'plainflowers':var submenuEnter='#F4F4F3';var submenuLeave='#F9F9F8';break;default:var submenuEnter='#EDEDEE';var submenuLeave='#F7F7F8';}
var submenuEnter={'background-color':submenuEnter};var submenuLeave={'background-color':submenuLeave};new Warp.Morph('div.mod-shadowbox ul.menu li.level1',submenuEnter,submenuLeave,{transition:Fx.Transitions.linear,duration:0},{transition:Fx.Transitions.sineIn,duration:300});new SmoothScroll({duration:500,transition:Fx.Transitions.Expo.easeOut});Warp.Base.matchHeight('div.headerbox div.deepest',20);Warp.Base.matchHeight('div.topbox div.deepest',20);Warp.Base.matchHeight('#bottom div.bottombox div.deepest',20);Warp.Base.matchHeight('#bottom2 div.bottombox div.deepest',20);Warp.Base.matchHeight('div.maintopbox div.deepest',20);Warp.Base.matchHeight('div.mainbottombox div.deepest',20);Warp.Base.matchHeight('div.contenttopbox div.deepest',20);Warp.Base.matchHeight('div.contentbottombox div.deepest',20);Warp.Base.matchHeight('#left, #right, div.right-3, div.left-3',20);}};window.addEvent('domready',WarpTemplate.start);