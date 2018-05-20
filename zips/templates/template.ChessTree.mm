<map version="freeplane 1.6.0">
<!--To view this file, download free mind mapping software Freeplane from http://freeplane.sourceforge.net -->
<attribute_registry SHOW_ATTRIBUTES="selected">
    <attribute_name RESTRICTED="true" NAME="ChessTreeProperties">
        <attribute_value VALUE=""/>
    </attribute_name>
    <attribute_name MANUAL="true" RESTRICTED="true" NAME="Language">
        <attribute_value VALUE="eng"/>
        <attribute_value VALUE="fre"/>
        <attribute_value VALUE="hun"/>
        <attribute_value VALUE="sym"/>
    </attribute_name>
</attribute_registry>
<node TEXT="e4" LOCALIZED_STYLE_REF="AutomaticLayout.level.root" FOLDED="false" ID="ID_477151011" CREATED="1521278881310" MODIFIED="1521624684613"><hook NAME="MapStyle">
    <conditional_styles>
        <conditional_style ACTIVE="true" STYLE_REF="White moves" LAST="true">
            <conjunct_condition>
                <node_periodic_level_condition PERIOD="2" REMAINDER="0"/>
                <script_condition>
                    <script>P_NUMBERING = /(\d+\.(\.\.)?)/&#xd;
P_MOVE = /(([0O]-[0O](-[0O])?)|(.?(([a-h][1-8]?)?x?)?[a-h][1-8](=.)?))[\+\#]?/&#xd;
P_NAG = /((\$\d{1,3})|([^\w]{0,2}))/&#xd;
notationPattern = /(?msu)^$P_NUMBERING?\s*$P_MOVE\s*$P_NAG?/&#xd;
&#xd;
return (this.node.getDisplayedText() ==~ notationPattern)</script>
                </script_condition>
            </conjunct_condition>
        </conditional_style>
        <conditional_style ACTIVE="true" STYLE_REF="Black moves" LAST="true">
            <conjunct_condition>
                <node_periodic_level_condition PERIOD="2" REMAINDER="1"/>
                <script_condition>
                    <script>P_NUMBERING = /(\d+\.(\.\.)?)/&#xd;
P_MOVE = /(([0O]-[0O](-[0O])?)|(.?(([a-h][1-8]?)?x?)?[a-h][1-8](=.)?))[\+\#]?/&#xd;
P_NAG = /((\$\d{1,3})|([^\w]{0,2}))/&#xd;
notationPattern = /(?msu)^$P_NUMBERING?\s*$P_MOVE\s*$P_NAG?/&#xd;
&#xd;
return (this.node.getDisplayedText() ==~ notationPattern)</script>
                </script_condition>
            </conjunct_condition>
        </conditional_style>
        <conditional_style ACTIVE="false" LOCALIZED_STYLE_REF="default" LAST="false"/>
    </conditional_styles>
    <properties show_icon_for_attributes="false" fit_to_viewport="false;" show_note_icons="true" chesstree_language="eng"/>

<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node" STYLE="oval" UNIFORM_SHAPE="true" VGAP_QUANTITY="24.0 pt">
<font SIZE="24"/>
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="default" COLOR="#000000" STYLE="fork">
<font NAME="Arial Unicode MS" SIZE="10" BOLD="false" ITALIC="false"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.details">
<font NAME="Arial Unicode MS" SIZE="8"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.attributes">
<font NAME="Arial Unicode MS" SIZE="8"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.note" COLOR="#000000" BACKGROUND_COLOR="#ffffff" TEXT_ALIGN="LEFT">
<font NAME="Arial Unicode MS" SIZE="8"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.floating">
<edge STYLE="hide_edge"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
<font NAME="Arial Unicode MS"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.user-defined" POSITION="right" STYLE="bubble">
<stylenode TEXT="White moves" COLOR="#000000" STYLE="bubble" UNIFORM_SHAPE="true" TEXT_ALIGN="CENTER" VGAP_QUANTITY="5.0 pt" MIN_WIDTH="50.0 px">
<font SIZE="12" BOLD="true"/>
<edge STYLE="bezier" WIDTH="1" DASH="SOLID"/>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
</stylenode>
<stylenode TEXT="Black moves" COLOR="#000000" BACKGROUND_COLOR="#666666" STYLE="bubble" UNIFORM_SHAPE="true" TEXT_ALIGN="CENTER" VGAP_QUANTITY="5.0 pt" MIN_WIDTH="50.0 px">
<font SIZE="12" BOLD="true"/>
<edge STYLE="bezier" WIDTH="1" DASH="SOLID"/>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
</stylenode>
<stylenode TEXT="Opening" COLOR="#808080" STYLE="oval">
<font NAME="Georgia" SIZE="8" BOLD="true" ITALIC="true"/>
<edge STYLE="hide_edge" COLOR="#808080" WIDTH="thin"/>
</stylenode>
<stylenode TEXT="Explanation" COLOR="#000000" STYLE="fork" UNIFORM_SHAPE="true" TEXT_ALIGN="LEFT" MAX_WIDTH="200.0 px" MIN_WIDTH="50.0 px">
<font SIZE="8" BOLD="false"/>
<edge STYLE="hide_edge" COLOR="#ffffff" WIDTH="thin"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" COLOR="#000000" STYLE="bubble" UNIFORM_SHAPE="true" TEXT_ALIGN="CENTER" VGAP_QUANTITY="5.0 pt" MIN_WIDTH="50.0 px">
<font SIZE="12" BOLD="true"/>
<edge STYLE="bezier"/>
</stylenode>
</stylenode>
</stylenode>
</map_styles>
</hook>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="Language" VALUE="hun"/>
<attribute NAME="ChessTreeProperties" VALUE=""/>
<edge STYLE="bezier"/>
<node TEXT="e5" POSITION="right" ID="ID_1804614164" CREATED="1521562623507" MODIFIED="1521563351564" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="52.249998860061204 pt" VSHIFT_QUANTITY="71.99999785423284 pt">
<node TEXT="King&apos;s&#xa;pawn" STYLE_REF="Opening" ID="ID_1767412475" CREATED="1521562657972" MODIFIED="1521562933548" HGAP_QUANTITY="-43.74999827891593 pt" VSHIFT_QUANTITY="-5.249999843537812 pt">
<hook NAME="FreeNode"/>
</node>
<node TEXT="d3" ID="ID_1811020991" CREATED="1521563277499" MODIFIED="1521563356308" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="56.74999872595075 pt" VSHIFT_QUANTITY="0.7499999776482589 pt">
<node TEXT="Indian" STYLE_REF="Opening" ID="ID_389680799" CREATED="1521563333484" MODIFIED="1521563356308" HGAP_QUANTITY="-51.99999803304678 pt" VSHIFT_QUANTITY="10.499999687075626 pt">
<hook NAME="FreeNode"/>
</node>
<node TEXT="d4" ID="ID_1950904324" CREATED="1521828969882" MODIFIED="1521828974259">
<node TEXT="ez egy j&#xf3; l&#xe9;p&#xe9;s lenne" ID="ID_1112324717" CREATED="1521828975425" MODIFIED="1521828981347"/>
<node TEXT="asd" ID="ID_855606667" CREATED="1521829190009" MODIFIED="1521829191059"/>
</node>
</node>
</node>
<node TEXT="c5" POSITION="right" ID="ID_1220149164" CREATED="1521562707531" MODIFIED="1521563223052" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="52.249998860061204 pt" VSHIFT_QUANTITY="-47.99999856948857 pt">
<node TEXT="Explanation..." STYLE_REF="Explanation" ID="ID_1989574865" CREATED="1521562879171" MODIFIED="1521563526726" HGAP_QUANTITY="17.749999888241295 pt" VSHIFT_QUANTITY="43.49999870359901 pt"><richcontent TYPE="DETAILS">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Node attributes can be:
    </p>
    <p>
      [&quot;Odds&quot;] - if exists, pie chart will be generated as a child node with Explanation style.
    </p>
    <p>
      [&quot;Freq&quot;] - if exists, width of node's incomming edge (or connector) will be adjusted accordingly.
    </p>
  </body>
</html>
</richcontent>
<hook NAME="FreeNode"/>
</node>
</node>
</node>
</map>
