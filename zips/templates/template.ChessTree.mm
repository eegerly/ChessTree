<map version="freeplane 1.6.0">
<!--To view this file, download free mind mapping software Freeplane from http://freeplane.sourceforge.net -->
<attribute_registry SHOW_ATTRIBUTES="selected">
    <attribute_name MANUAL="true" NAME="Language">
        <attribute_value VALUE="eng"/>
        <attribute_value VALUE="hun"/>
        <attribute_value VALUE="sym"/>
        <attribute_value VALUE="fre"/>
    </attribute_name>
</attribute_registry>
<node TEXT="ChessTree" LOCALIZED_STYLE_REF="AutomaticLayout.level.root" FOLDED="false" ID="ID_477151011" CREATED="1521278881310" MODIFIED="1540723695481" VGAP_QUANTITY="5.0 pt"><hook NAME="MapStyle">
    <conditional_styles>
        <conditional_style ACTIVE="true" STYLE_REF="Script" LAST="true">
            <attribute_exists_condition ATTRIBUTE="script1"/>
        </conditional_style>
        <conditional_style ACTIVE="true" STYLE_REF="White moves" LAST="true">
            <conjunct_condition>
                <attribute_contains_condition ATTRIBUTE="FEN" VALUE=" b " MATCH_CASE="false" MATCH_APPROXIMATELY="false"/>
                <style_equals_condition LOCALIZED_TEXT="default"/>
            </conjunct_condition>
        </conditional_style>
        <conditional_style ACTIVE="true" STYLE_REF="Black moves" LAST="true">
            <conjunct_condition>
                <attribute_contains_condition ATTRIBUTE="FEN" VALUE=" w " MATCH_CASE="false" MATCH_APPROXIMATELY="false"/>
                <style_equals_condition LOCALIZED_TEXT="default"/>
            </conjunct_condition>
        </conditional_style>
        <conditional_style ACTIVE="true" STYLE_REF="White moves" LAST="true">
            <conjunct_condition>
                <script_condition user_name="IsMove">
                    <script>P_NUMBERING = /(\d+\.(\.\.)?)/&#xd;
P_MOVE = /(([0O]-[0O](-[0O])?)|(.?(([a-h][1-8]?)?x?)?[a-h][1-8](=.)?))[\+\#]?/&#xd;
P_NAG = /((\$\d{1,3})|([^\w]{0,2}))/&#xd;
notationPattern = /(?msu)^$P_NUMBERING?\s*$P_MOVE\s*$P_NAG?/&#xd;
&#xd;
return (this.node.getDisplayedText() ==~ notationPattern)</script>
                </script_condition>
                <script_condition>
                    <script>//IsThisWhite_parentFEN&#xd;
if (this.node.parent==null) return false;&#xd;
else if (!this.node.parent.attributes.containsKey(&quot;FEN&quot;)) return false;&#xd;
else {&#xd;
    def m = (this.node.parent[&quot;FEN&quot;] =~ /(?msu).* ([bw]) .* \d+ (\d+).*/)&#xd;
    if (m.size() == 0) return false&#xd;
    else {&#xd;
        def updateFEN = !this.node.attributes.containsKey(&quot;FEN&quot;)&#xd;
        def color_next = &apos;wb&apos;-m[0][1]&#xd;
        def moveNumber_next = m[0][2].toInteger() + (color_next==&apos;w&apos;?1:0)&#xd;
        &#xd;
        if (!updateFEN) {&#xd;
            /* Prevent FEN update with empty table when it was correct */&#xd;
            updateFEN = !(this.node[&quot;FEN&quot;] ==~ /(?msu).* $color_next .* \d+ $moveNumber_next.*/)&#xd;
        }&#xd;
        if (updateFEN) {&#xd;
            this.node[&quot;FEN&quot;] = &quot;8/8/8/8/8/8/8/8 ${color_next} - - 0 ${moveNumber_next}&quot;&#xd;
       }&#xd;
        return m[0][1]==&quot;w&quot;&#xd;
    }&#xd;
}&#xd;
&#xd;
&#xd;
</script>
                </script_condition>
            </conjunct_condition>
        </conditional_style>
        <conditional_style ACTIVE="true" STYLE_REF="Black moves" LAST="true">
            <conjunct_condition>
                <script_condition user_name="IsMove">
                    <script>P_NUMBERING = /(\d+\.(\.\.)?)/&#xd;
P_MOVE = /(([0O]-[0O](-[0O])?)|(.?(([a-h][1-8]?)?x?)?[a-h][1-8](=.)?))[\+\#]?/&#xd;
P_NAG = /((\$\d{1,3})|([^\w]{0,2}))/&#xd;
notationPattern = /(?msu)^$P_NUMBERING?\s*$P_MOVE\s*$P_NAG?/&#xd;
&#xd;
return (this.node.getDisplayedText() ==~ notationPattern)</script>
                </script_condition>
                <script_condition>
                    <script>//IsThisBlack_parentFEN&#xd;
if (this.node.parent==null) return false;&#xd;
else if (!this.node.parent.attributes.containsKey(&quot;FEN&quot;)) return false;&#xd;
else {&#xd;
    def m = (this.node.parent[&quot;FEN&quot;] =~ /(?msu).* ([bw]) .* \d+ (\d+).*/)&#xd;
    if (m.size() == 0) return false&#xd;
    else {&#xd;
        def updateFEN = !this.node.attributes.containsKey(&quot;FEN&quot;)&#xd;
        def color_next = &apos;wb&apos;-m[0][1]&#xd;
        def moveNumber_next = m[0][2].toInteger() + (color_next==&apos;w&apos;?1:0)&#xd;
        &#xd;
        if (!updateFEN) {&#xd;
            /* Prevent FEN update with empty table when it was correct */&#xd;
            updateFEN = !(this.node[&quot;FEN&quot;] ==~ /(?msu).* $color_next .* \d+ $moveNumber_next.*/)&#xd;
        }&#xd;
        if (updateFEN) {&#xd;
            this.node[&quot;FEN&quot;] = &quot;8/8/8/8/8/8/8/8 ${color_next} - - 0 ${moveNumber_next}&quot;&#xd;
       }&#xd;
        return m[0][1]==&quot;b&quot;&#xd;
    }&#xd;
}&#xd;
&#xd;
&#xd;
</script>
                </script_condition>
            </conjunct_condition>
        </conditional_style>
    </conditional_styles>
    <properties chesstree_NAG="hide" chesstree_odds="show" Language="eng" chesstree_language="eng" show_icon_for_attributes="false" chesstree_numbering="none" fit_to_viewport="false;" chesstree_connectors="freq" chesstree_board_size="medium" show_note_icons="true" show_notes_in_map="false"/>

<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node" STYLE="oval" UNIFORM_SHAPE="true" VGAP_QUANTITY="24.0 pt">
<font SIZE="24"/>
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="default" COLOR="#000000" STYLE="bubble">
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
<stylenode TEXT="Black moves" COLOR="#000000" BACKGROUND_COLOR="#999999" STYLE="bubble" UNIFORM_SHAPE="true" TEXT_ALIGN="CENTER" VGAP_QUANTITY="5.0 pt" MIN_WIDTH="50.0 px">
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
<stylenode TEXT="Starting position" COLOR="#000000" STYLE="rectangle" TEXT_ALIGN="CENTER" MIN_WIDTH="50.0 px" VGAP_QUANTITY="5.0 pt" BORDER_WIDTH="3.0 px" BORDER_COLOR_LIKE_EDGE="true">
<font SIZE="10" BOLD="true"/>
<edge STYLE="bezier" WIDTH="1"/>
</stylenode>
<stylenode TEXT="Script" BACKGROUND_COLOR="#ff99ff" BACKGROUND_ALPHA="82"/>
<stylenode TEXT="Diff.Added" COLOR="#ffffff" BACKGROUND_COLOR="#00c800" STYLE="oval" SHAPE_HORIZONTAL_MARGIN="0.0 pt" SHAPE_VERTICAL_MARGIN="0.0 pt" TEXT_ALIGN="CENTER" MAX_WIDTH="100.0 px" MIN_WIDTH="25.0 px" BORDER_WIDTH="2.0 px" BORDER_COLOR_LIKE_EDGE="false" BORDER_COLOR="#00c800" VGAP_QUANTITY="2.0 pt">
<icon BUILTIN="very_positive"/>
<font SIZE="8" BOLD="false"/>
<edge STYLE="hide_edge" COLOR="#ffffff" WIDTH="thin"/>
</stylenode>
<stylenode TEXT="Diff.Removed" COLOR="#ffffff" BACKGROUND_COLOR="#c80000" STYLE="oval" SHAPE_HORIZONTAL_MARGIN="0.0 pt" SHAPE_VERTICAL_MARGIN="0.0 pt" TEXT_ALIGN="CENTER" MAX_WIDTH="100.0 px" MIN_WIDTH="25.0 px" BORDER_WIDTH="2.0 px" BORDER_COLOR_LIKE_EDGE="false" BORDER_COLOR="#c80000" VGAP_QUANTITY="2.0 pt">
<icon BUILTIN="very_negative"/>
<edge STYLE="hide_edge" COLOR="#ffffff" WIDTH="thin"/>
<font SIZE="8" BOLD="false"/>
</stylenode>
<stylenode TEXT="Diff.Priority" COLOR="#ffffff" BACKGROUND_COLOR="#0000c8" STYLE="oval" SHAPE_HORIZONTAL_MARGIN="0.0 pt" SHAPE_VERTICAL_MARGIN="0.0 pt" TEXT_ALIGN="CENTER" MAX_WIDTH="100.0 px" MIN_WIDTH="25.0 px" BORDER_WIDTH="2.0 px" BORDER_COLOR_LIKE_EDGE="false" BORDER_COLOR="#0000c8" VGAP_QUANTITY="2.0 pt">
<icon BUILTIN="mindmap"/>
<font SIZE="8" BOLD="false"/>
<edge STYLE="hide_edge" COLOR="#ffffff" WIDTH="thin"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" COLOR="#000000" STYLE="wide_hexagon" TEXT_ALIGN="CENTER" VGAP_QUANTITY="5.0 pt" MIN_WIDTH="50.0 px" BORDER_WIDTH="3.0 px" BORDER_COLOR_LIKE_EDGE="false" BORDER_COLOR="#000000" BORDER_DASH="SOLID">
<font SIZE="12" BOLD="true"/>
<edge STYLE="bezier"/>
</stylenode>
</stylenode>
</stylenode>
</map_styles>
</hook>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<edge STYLE="bezier"/>
<hook NAME="accessories/plugins/HierarchicalIcons.properties"/>
<node TEXT="Template" POSITION="right" ID="ID_1024013937" CREATED="1540721925732" MODIFIED="1540722042399">
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<richcontent TYPE="DETAILS">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Delete this branch.
    </p>
  </body>
</html>
</richcontent>
<node TEXT="Starting Position" STYLE_REF="Starting position" ID="ID_1259526390" CREATED="1540722046552" MODIFIED="1540722734218" VGAP_QUANTITY="5.0 pt">
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"/>
<richcontent TYPE="DETAILS">

<html>
  <head>
    
  </head>
  <body>
    <p>
      A game/opening can start from here. This node shall contain FEN attribute with starting position.
    </p>
  </body>
</html>
</richcontent>
<node TEXT="e4" ID="ID_1770698008" CREATED="1540722202050" MODIFIED="1540722974736" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="25.999999642372153 pt" VSHIFT_QUANTITY="-11.999999642372142 pt">
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 b - - 0 1"/>
<node TEXT="e5" ID="ID_896407766" CREATED="1521562623507" MODIFIED="1540722980975" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="52.249998860061204 pt">
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 w - - 0 2"/>
<node TEXT="Nc3" ID="ID_1288275139" CREATED="1521563277499" MODIFIED="1540722652128" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="57.49999870359901 pt" VSHIFT_QUANTITY="2.9999999105930355 pt">
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 b - - 0 2"/>
<node TEXT="Vienna&#xa;game" STYLE_REF="Opening" ID="ID_419435261" CREATED="1521563333484" MODIFIED="1540722652125" HGAP_QUANTITY="-52.74999801069504 pt" VSHIFT_QUANTITY="23.999999284744284 pt">
<hook NAME="FreeNode"/>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
</node>
</node>
<node TEXT="King&apos;s&#xa;pawn" STYLE_REF="Opening" ID="ID_1082206395" CREATED="1521562657972" MODIFIED="1540722741654" HGAP_QUANTITY="-47.49999816715723 pt" VSHIFT_QUANTITY="1.4999999552965235 pt">
<hook NAME="FreeNode"/>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
</node>
<node TEXT="f4" ID="ID_1950904324" CREATED="1521828969882" MODIFIED="1540722993452" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="55.99999874830249 pt" VSHIFT_QUANTITY="20.249999396502986 pt">
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 b - - 0 2"/>
<node TEXT="King&apos;s g." STYLE_REF="Opening" ID="ID_807161517" CREATED="1540722565580" MODIFIED="1540722986774" HGAP_QUANTITY="-93.99999678134928 pt" VSHIFT_QUANTITY="15.749999530613433 pt">
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
</node>
<node TEXT="exf4" ID="ID_1042903409" CREATED="1540722547588" MODIFIED="1540723003731" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="20.749999798834327 pt" VSHIFT_QUANTITY="-21.74999935179951 pt">
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 w - - 0 3"/>
<richcontent TYPE="DETAILS">

<html>
  <head>
    
  </head>
  <body>
    <p>
      !! (NAG)
    </p>
  </body>
</html>
</richcontent>
<node TEXT="This is an explanation" STYLE_REF="Explanation" ID="ID_10383160" CREATED="1540722762247" MODIFIED="1540723003726" HGAP_QUANTITY="-22.749998904764688 pt" VSHIFT_QUANTITY="42.74999872595075 pt">
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<richcontent TYPE="DETAILS">

<html>
  <head>
    
  </head>
  <body>
    <p>
      With details.
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
</node>
</node>
<node ID="ID_535174833" CREATED="1527457060986" MODIFIED="1540723029484" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="50.74999890476469 pt" VSHIFT_QUANTITY="-14.999999552965171 pt"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      c5
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 w - - 0 2"/>
<node TEXT="Sicilian d." STYLE_REF="Opening" ID="ID_411558666" CREATED="1527457164489" MODIFIED="1540722971203" HGAP_QUANTITY="-58.74999783188111 pt" VSHIFT_QUANTITY="-23.249999307096022 pt">
<hook NAME="FreeNode"/>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
</node>
<node ID="ID_249095042" CREATED="1527457060995" MODIFIED="1540723090884" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="51.499998882412946 pt" VSHIFT_QUANTITY="14.999999552965178 pt"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Nc3
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 b - - 0 2"/>
<node TEXT="Closed" STYLE_REF="Opening" ID="ID_1237624932" CREATED="1527457164506" MODIFIED="1540723039065" HGAP_QUANTITY="-45.24999823421244 pt" VSHIFT_QUANTITY="-0.7499999776482587 pt">
<hook NAME="FreeNode"/>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
</node>
<node ID="ID_1569339788" CREATED="1527457060999" MODIFIED="1540723173092" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="64.24999850243334 pt" VSHIFT_QUANTITY="55.49999834597115 pt"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Nc6
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 w - - 0 3"/>
<node TEXT="Traditional" STYLE_REF="Opening" ID="ID_737985422" CREATED="1527457164515" MODIFIED="1540723094271" HGAP_QUANTITY="-73.7499973848463 pt" VSHIFT_QUANTITY="-17.249999485909953 pt">
<hook NAME="FreeNode"/>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
</node>
<node ID="ID_206065873" CREATED="1527457061002" MODIFIED="1540723178168" VGAP_QUANTITY="5.0 pt" HGAP_QUANTITY="83.74999792128807 pt" VSHIFT_QUANTITY="53.99999839067464 pt"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      g3
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 b - - 0 3"/>
<node TEXT="Flanchetto v." STYLE_REF="Opening" ID="ID_2738852" CREATED="1527457164524" MODIFIED="1540723178163" HGAP_QUANTITY="-82.74999711662541 pt" VSHIFT_QUANTITY="-17.999999463558215 pt">
<hook NAME="FreeNode"/>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
</node>
<node ID="ID_1297257048" CREATED="1527457061006" MODIFIED="1538811241190"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      g6
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 w - - 0 4"/>
<node ID="ID_1478563909" CREATED="1527457061009" MODIFIED="1538811724114"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Bg2
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 b - - 0 4"/>
<node ID="ID_42514117" CREATED="1527457061012" MODIFIED="1538811724113"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Bg7
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 w - - 0 5"/>
<node ID="ID_1026263203" CREATED="1527457061015" MODIFIED="1538811667827"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      d3
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 b - - 0 5"/>
<node ID="ID_1114825034" CREATED="1527457061017" MODIFIED="1538811241184"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      d6
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 w - - 0 6"/>
<node ID="ID_1732416384" CREATED="1527457061020" MODIFIED="1540723302691" VGAP_QUANTITY="5.0 pt"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      f4
    </p>
  </body>
</html>
</richcontent>
<arrowlink SHAPE="CUBIC_CURVE" COLOR="#808080" WIDTH="2" TRANSPARENCY="200" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_1105747980" STARTINCLINATION="101;70;" ENDINCLINATION="-92;-84;" STARTARROW="NONE" ENDARROW="NONE"/>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 b - - 0 6"/>
<node ID="ID_1105747980" CREATED="1527457061023" MODIFIED="1540723302670" HGAP_QUANTITY="-295.7499907687309 pt" VSHIFT_QUANTITY="74.24999778717763 pt"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      e6
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 w - - 0 7"/>
<edge STYLE="hide_edge"/>
<node ID="ID_837937620" CREATED="1527457061026" MODIFIED="1538811724110"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Nf3
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 b - - 0 7"/>
<node ID="ID_1303266442" CREATED="1527457061029" MODIFIED="1538811724109"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Nge7
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 w - - 0 8"/>
<node ID="ID_1317502694" CREATED="1527457061031" MODIFIED="1538811667821"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      O-O
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 b - - 0 8"/>
<node ID="ID_1696465234" CREATED="1527457061033" MODIFIED="1538811241172"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      O-O
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 w - - 0 9"/>
<node ID="ID_852515541" CREATED="1527457061036" MODIFIED="1540723274056" VGAP_QUANTITY="5.0 pt"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Be3
    </p>
  </body>
</html>
</richcontent>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="Odds" VALUE="23,30,47"/>
<attribute NAME="FEN" VALUE="8/8/8/8/8/8/8/8 b - - 0 9"/>
<node TEXT="Odds" STYLE_REF="Explanation" ID="ID_1622885871" CREATED="1538945546031" MODIFIED="1540723284100" HGAP_QUANTITY="8.00000017881393 pt" VSHIFT_QUANTITY="44.24999868124728 pt">
<hook NAME="FreeNode"/>
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="Odds" VALUE="23,30,47"/>
<richcontent TYPE="DETAILS">

<html>
  <head>
    
  </head>
  <body>
    <img src="./img_AddonTest/odds_ID_166249047.png"/>
  </body>
</html>
</richcontent>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</node>
</map>
