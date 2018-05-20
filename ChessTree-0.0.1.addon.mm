<map version="freeplane 1.6.0">
<!--To view this file, download free mind mapping software Freeplane from http://freeplane.sourceforge.net -->
<node TEXT="ChessTree" FOLDED="false" ID="ID_1869326925" CREATED="1521562113754" MODIFIED="1522496029940" LINK="http://noUpdateURL.com" BACKGROUND_COLOR="#97c7dc" STYLE="oval">
<font SIZE="16" BOLD="true" ITALIC="true"/>
<hook NAME="MapStyle">
    <properties fit_to_viewport="false" show_icon_for_attributes="true" show_note_icons="true" edgeColorConfiguration="#808080ff,#ff0000ff,#0000ffff,#00ff00ff,#ff00ffff,#00ffffff,#7c0000ff,#00007cff,#007c00ff,#7c007cff,#007c7cff,#7c7c00ff"/>

<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node" STYLE="oval" UNIFORM_SHAPE="true" VGAP_QUANTITY="24.0 pt">
<font SIZE="24"/>
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="default" ICON_SIZE="12.0 pt" COLOR="#000000" STYLE="fork">
<font NAME="SansSerif" SIZE="10" BOLD="false" ITALIC="false"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.details"/>
<stylenode LOCALIZED_TEXT="defaultstyle.attributes">
<font SIZE="9"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.note" COLOR="#000000" BACKGROUND_COLOR="#ffffff" TEXT_ALIGN="LEFT"/>
<stylenode LOCALIZED_TEXT="defaultstyle.floating">
<edge STYLE="hide_edge"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.user-defined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="styles.topic" COLOR="#18898b" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subtopic" COLOR="#cc3300" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subsubtopic" COLOR="#669900">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.important">
<icon BUILTIN="yes"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" COLOR="#000000" STYLE="oval" SHAPE_HORIZONTAL_MARGIN="10.0 pt" SHAPE_VERTICAL_MARGIN="10.0 pt">
<font SIZE="18"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,1" COLOR="#0033ff">
<font SIZE="16"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,2" COLOR="#00b439">
<font SIZE="14"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,3" COLOR="#990000">
<font SIZE="12"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,4" COLOR="#111111">
<font SIZE="10"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,5"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,6"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,7"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,8"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,9"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,10"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,11"/>
</stylenode>
</stylenode>
</map_styles>
</hook>
<hook NAME="AutomaticEdgeColor" COUNTER="11" RULE="ON_BRANCH_CREATION"/>
<attribute_layout NAME_WIDTH="107.99999678134928 pt" VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="name" VALUE="chessTree"/>
<attribute NAME="version" VALUE="0.0.1"/>
<attribute NAME="author" VALUE="Gergely Kiss"/>
<attribute NAME="freeplaneVersionFrom" VALUE="1.6.4"/>
<attribute NAME="freeplaneVersionTo" VALUE=""/>
<attribute NAME="updateUrl" VALUE="http://noUpdateURL.com" OBJECT="java.net.URI|http://noUpdateURL.com"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      The homepage of this add-on should be set as the link of the root node.
    </p>
    <p>
      The basic properties of this add-on. They can be used in script names and other attributes, e.g. &quot;${name}.groovy&quot;.
    </p>
    <ul>
      <li>
        name: The name of the add-on, normally a technically one (no spaces, no special characters except _.-).
      </li>
      <li>
        author: Author's name(s) and (optionally) email adresses.
      </li>
      <li>
        version: Since it's difficult to protect numbers like 1.0 from Freeplane's number parser it's advised to prepend a 'v' to the number, e.g. 'v1.0'.
      </li>
      <li>
        freeplane-version-from: The oldest compatible Freeplane version. The add-on will not be installed if the Freeplane version is too old.
      </li>
      <li>
        freeplane-version-to: Normally empty: The newest compatible Freeplane version. The add-on will not be installed if the Freeplane version is too new.
      </li>
      <li>
        updateUrl: URL of the file containing information (version, download url) on the latest version of this add-on. By default: &quot;${homepage}/version.properties&quot;
      </li>
    </ul>
  </body>
</html>
</richcontent>
<node TEXT="description" POSITION="left" ID="ID_752418840" CREATED="1521562135104" MODIFIED="1522496029951">
<edge COLOR="#ff0000"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Description would be awkward to edit as an attribute.
    </p>
    <p>
      So you have to put the add-on description as a child of the <i>'description'</i>&#160;node.
    </p>
    <p>
      To translate the description you have to define a translation for the key 'addons.${name}.description'.
    </p>
  </body>
</html>
</richcontent>
<node ID="ID_281132702" CREATED="1521563587956" MODIFIED="1521563734014"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      This addon is intended to ease the creation and maintenance of mindmaps containing trees for chess movements.
    </p>
    <p>
      
    </p>
    <p>
      0.) Template is available after addon installation from <i><b>File</b></i>&#160; --&gt; <i><b>New map from template...</b></i>&#160;choosing <i><b>template.ChessTree.mm</b></i>. Any additional information can be found in the template.
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="changes" POSITION="left" ID="ID_845634758" CREATED="1521562135109" MODIFIED="1522496029957">
<edge COLOR="#0000ff"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      Change log of this add-on: append one node for each noteworthy version and put the details for each version into a child node.
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="license" FOLDED="true" POSITION="left" ID="ID_1331637895" CREATED="1521562135113" MODIFIED="1522496029963">
<edge COLOR="#00ff00"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      The add-ons's license that the user has to accept before she can install it.
    </p>
    <p>
      
    </p>
    <p>
      The License text has to be entered as a child of the <i>'license'</i>&#160;node, either as plain text or as HTML.
    </p>
  </body>
</html>
</richcontent>
<node TEXT="&#xa;This add-on is free software: you can redistribute it and/or modify&#xa;it under the terms of the GNU General Public License as published by&#xa;the Free Software Foundation, either version 2 of the License, or&#xa;(at your option) any later version.&#xa;&#xa;This program is distributed in the hope that it will be useful,&#xa;but WITHOUT ANY WARRANTY; without even the implied warranty of&#xa;MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the&#xa;GNU General Public License for more details.&#xa;" ID="ID_1555852289" CREATED="1521562135117" MODIFIED="1521566722845"/>
</node>
<node TEXT="preferences.xml" POSITION="left" ID="ID_136508631" CREATED="1521562135121" MODIFIED="1522496029970">
<edge COLOR="#ff00ff"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      <font color="#000000" face="SansSerif, sans-serif">The child node contains the add-on configuration as an extension to mindmapmodemenu.xml (in Tools-&gt;Preferences-&gt;Add-ons). </font>
    </p>
    <p>
      <font color="#000000" face="SansSerif, sans-serif">Every property in the configuration should receive a default value in <i>default.properties</i>&#160;node.</font>
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="default.properties" POSITION="left" ID="ID_1494843788" CREATED="1521562135125" MODIFIED="1522496029976">
<edge COLOR="#00ffff"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      These properties play together with the preferences: Each property defined in the preferences should have a default value in the attributes of this node.
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="translations" POSITION="left" ID="ID_461099033" CREATED="1521562135130" MODIFIED="1522496029982">
<edge COLOR="#7c0000"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      The translation keys that this script uses. Define one child node per supported locale. The attributes contain the translations. Define at least
    </p>
    <ul>
      <li>
        'addons.${name}' for the add-on's name
      </li>
      <li>
        'addons.${name}.description' for the description, e.g. in the add-on overview dialog (not necessary for English)
      </li>
      <li>
        'addons.${name}.&lt;scriptname&gt;' for each script since it will be the menu title.
      </li>
    </ul>
  </body>
</html>
</richcontent>
<node TEXT="en" ID="ID_1779268052" CREATED="1521562135133" MODIFIED="1522494751169" MAX_WIDTH="322.49999056756525 pt" MIN_WIDTH="322.49999056756525 pt">
<attribute_layout NAME_WIDTH="155.99999535083785 pt" VALUE_WIDTH="123.74999631196272 pt"/>
<attribute NAME="addons.${name}" VALUE="ChessTree"/>
<attribute NAME="addon.${name}.updateConnectors" VALUE="Update connectors"/>
<attribute NAME="addon.${name}.updateNotation" VALUE="Update notation"/>
<attribute NAME="addon.${name}.updateOddsPieChart" VALUE="Update odds pie-chart"/>
<attribute NAME="addon.${name}.pasteBranch" VALUE="Paste branch..."/>
</node>
</node>
<node TEXT="deinstall" POSITION="left" ID="ID_1510539068" CREATED="1521562135137" MODIFIED="1522496029987">
<edge COLOR="#00007c"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      List of files and/or directories to remove on uninstall
    </p>
  </body>
</html>
</richcontent>
<attribute_layout NAME_WIDTH="52.499998435378124 pt" VALUE_WIDTH="271.4999919086697 pt"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}.script.xml"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/updateConnectors.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/updateNotation.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/updateOddsPieChart.groovy"/>
<attribute NAME="delete" VALUE="${installationbase}/templates/template.ChessTree.mm"/>
<attribute NAME="delete" VALUE="${installationbase}/lib/ChessTree.jar"/>
<attribute NAME="delete" VALUE="${installationbase}/addons/${name}/scripts/pasteBranch.groovy"/>
</node>
<node TEXT="scripts" POSITION="right" ID="ID_836008002" CREATED="1521562135167" MODIFIED="1522496029995">
<edge COLOR="#007c00"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      An add-on may contain multiple scripts. The node text defines the script name (e.g. inserInlineImage.groovy). The name must have a suffix of a supported script language like .groovy or .js and may only consist of letters and digits. The script properties have to be configured via attributes:
    </p>
    <p>
      
    </p>
    <p>
      * menuLocation: &lt;locationkey&gt;
    </p>
    <p>
      &#160;&#160;&#160;- Defines where the menu location.
    </p>
    <p>
      &#160;&#160;&#160;-&#160;See mindmapmodemenu.xml for how the menu locations look like.
    </p>
    <p>
      &#160;&#160;&#160;- http://freeplane.bzr.sf.net/bzr/freeplane/freeplane_program/trunk/annotate/head%3A/freeplane/resources/xml/mindmapmodemenu.xml
    </p>
    <p>
      &#160;&#160;&#160;- This attribute is mandatory
    </p>
    <p>
      
    </p>
    <p>
      * menuTitleKey: &lt;key&gt;
    </p>
    <p>
      &#160;&#160;&#160;- The menu item title will be looked up under the translation key &lt;key&gt; - don't forget to define its translation.
    </p>
    <p>
      &#160;&#160;&#160;- This attribute is mandatory
    </p>
    <p>
      
    </p>
    <p>
      * executionMode: &lt;mode&gt;
    </p>
    <p>
      &#160;&#160;&#160;- The execution mode as described in the Freeplane wiki (http://freeplane.sourceforge.net/wiki/index.php/Scripting)
    </p>
    <p>
      &#160;&#160;&#160;- ON_SINGLE_NODE: Execute the script once. The <i>node</i>&#160;variable is set to the selected node.
    </p>
    <p>
      &#160;&#160;&#160;- ON_SELECTED_NODE: Execute the script n times for n selected nodes, once for each node.
    </p>
    <p>
      &#160;&#160;&#160;- ON_SELECTED_NODE_RECURSIVELY: Execute the script on every selected node and recursively on all of its children.
    </p>
    <p>
      &#160;&#160;&#160;- In doubt use ON_SINGLE_NODE.
    </p>
    <p>
      &#160;&#160;&#160;- This attribute is mandatory
    </p>
    <p>
      
    </p>
    <p>
      * keyboardShortcut: &lt;shortcut&gt;
    </p>
    <p>
      &#160;&#160;&#160;- Optional: keyboard combination / accelerator for this script, e.g. control alt I
    </p>
    <p>
      &#160;&#160;&#160;- Use lowercase letters for modifiers and uppercase for letters. Use no + signs.
    </p>
    <p>
      &#160;&#160;&#160;- The available key names are listed at http://download.oracle.com/javase/1.4.2/docs/api/java/awt/event/KeyEvent.html#VK_0
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;In the list only entries with a 'VK_' prefix count. Omit the prefix in the shortcut definition.
    </p>
    <p>
      
    </p>
    <p>
      * Permissions&#160;that the script(s) require, each either false or true:
    </p>
    <p>
      &#160;&#160;&#160;- execute_scripts_without_asking
    </p>
    <p>
      &#160;&#160;&#160;- execute_scripts_without_file_restriction: permission to read files
    </p>
    <p>
      &#160;&#160;&#160;- execute_scripts_without_write_restriction: permission to create/change/delete files
    </p>
    <p>
      &#160;&#160;&#160;- execute_scripts_without_exec_restriction: permission to execute other programs
    </p>
    <p>
      &#160;&#160;&#160;- execute_scripts_without_network_restriction: permission to access the network
    </p>
    <p>
      &#160;&#160;Notes:
    </p>
    <p>
      &#160;&#160;- The set of permissions is fixed.
    </p>
    <p>
      &#160;&#160;- Don't change the attribute names, don't omit one.
    </p>
    <p>
      &#160;&#160;- Set the values either to true or to false
    </p>
    <p>
      &#160;&#160;- In any case set execute_scripts_without_asking to true unless you want to annoy users.
    </p>
  </body>
</html>
</richcontent>
<node TEXT="updateConnectors.groovy" FOLDED="true" ID="ID_776844026" CREATED="1521565216600" MODIFIED="1521573018269">
<attribute_layout NAME_WIDTH="183.74999452382343 pt" VALUE_WIDTH="189.7499943450095 pt"/>
<attribute NAME="menuTitleKey" VALUE="addon.${name}.updateConnectors"/>
<attribute NAME="menuLocation" VALUE="/menu_bar/addons.${name}"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="true"/>
<node TEXT="import org.freeplane.features.link.ConnectorModel&#xd;&#xa;/*************/&#xd;&#xa;/** Globals **/&#xd;&#xa;/*************/&#xd;&#xa;&#xd;&#xa;MAXWIDTH = 15&#xd;&#xa;HSHIFT_LIMIT = -50&#xd;&#xa;/* Errors */&#xd;&#xa;errors = []&#xd;&#xa;E_ACCESS_METHOD_GETCONNECTOR = 1&#xd;&#xa;ROOT = this.node.map.root&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;/*************/&#xd;&#xa;/**** Main ***/ &#xd;&#xa;/*************/&#xd;&#xa;&#xd;&#xa;ROOT.findAllDepthFirst().each {&#xd;&#xa;    aNode = it    &#xd;&#xa;    /* Update edge based on [&quot;Freq&quot;] */&#xd;&#xa;    if (aNode.attributes.containsKey(&quot;Freq&quot;)) {&#xd;&#xa;        updateEdge(aNode);&#xd;&#xa;    }&#xd;&#xa;&#xd;&#xa;    /* Change edge to connector for &quot;(un)wrapped&quot; nodes (with negative (positive) horizontal shift) &#xd;&#xa;    with &quot;*moves&quot; style */&#xd;&#xa;    updateNodeConnector(aNode)&#xd;&#xa;&#xd;&#xa;    &#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;/* Error message handling */&#xd;&#xa;errorMsg = &quot;&quot;&#xd;&#xa;if (errors.contains(E_ACCESS_METHOD_GETCONNECTOR)) {&#xd;&#xa;    errorMsg += &quot;Width and transparency of connections cannot be set. Please set it manually.\n&quot;&#xd;&#xa;    &quot;Or run script from script editor as connection.getConnector() method can be accessed only from script editor.&quot;&#xd;&#xa;}&#xd;&#xa;if (errors.size() &gt; 0) {&#xd;&#xa;    ui.showMessage(errorMsg, 2)&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;return 0;&#xd;&#xa;&#xd;&#xa;/*************/&#xd;&#xa;/* Functions */&#xd;&#xa;/*************/&#xd;&#xa;&#xd;&#xa;def updateEdge(aNode) {&#xd;&#xa;    width = 0&#xd;&#xa;    if (aNode.parent != null) { // not the root &#xd;&#xa;        width = (aNode[&quot;Freq&quot;].toFloat()*MAXWIDTH/100.0).toInteger()&#xd;&#xa;    }&#xd;&#xa;    aNode.style.edge.setWidth(width)&#xd;&#xa;    //println aNode.style.edge.getModel().getDash()&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;def updateNodeConnector(aNode) {&#xd;&#xa;    hasConnectorFromParent = aNode.connectorsIn.collect{it.getSource().id == aNode.parent.id}.inject(false){a,b-&gt;a||b}&#xd;&#xa;    hasHiddenEdgeFromParent = aNode.style.edge.type == org.freeplane.features.edge.EdgeStyle.EDGESTYLE_HIDDEN&#xd;&#xa;    hasMovesStyle = (aNode.hasStyle(&quot;White moves&quot;) || aNode.hasStyle(&quot;Black moves&quot;))&#xd;&#xa;    hasNegativeHShift = (aNode.getHorizontalShift() &lt; HSHIFT_LIMIT)&#xd;&#xa;    &#xd;&#xa;    if (hasNegativeHShift &amp;&amp; hasMovesStyle &amp;&amp; (!hasHiddenEdgeFromParent || !hasConnectorFromParent)) {&#xd;&#xa;        aNode.connectorsIn.findAll{it.getSource().id == aNode.parent.id}.each {&#xd;&#xa;            aNode.removeConnector(it)&#xd;&#xa;        }&#xd;&#xa;        &#xd;&#xa;        conn = aNode.parent.addConnectorTo(aNode)&#xd;&#xa;&#xd;&#xa;        conn.setShape(&quot;CUBIC_CURVE&quot;)&#xd;&#xa;        conn.setColor(aNode.style.edge.color)&#xd;&#xa;        conn.setStartArrow(false)&#xd;&#xa;        conn.setEndArrow(false)&#xd;&#xa;        &#xd;&#xa;        def ConnectorModel connModel = null&#xd;&#xa;        try {&#xd;&#xa;            connModel = conn.getConnector()&#xd;&#xa;            if (connModel!=null) {&#xd;&#xa;                connModel.setWidth(aNode.style.edge.width)&#xd;&#xa;                connModel.setAlpha(255)&#xd;&#xa;            &#xd;&#xa;            }&#xd;&#xa;        } catch (e) {&#xd;&#xa;            errors.add(E_ACCESS_METHOD_GETCONNECTOR)&#xd;&#xa;            errors = errors.unique()&#xd;&#xa;        }&#xd;&#xa;        vShift = (aNode.getVerticalShift() + aNode.style.getMinNodeWidth())&gt;&gt;1&#xd;&#xa;        //aNode.children[0].findAllDepthFirst().findAll{it.getHorizontalShift()!=0}.each{if (it.getVerticalShift()) println it.getVerticalShift()}&#xd;&#xa;        vShiftOffset = aNode.children[0].findAllDepthFirst().findAll{it.getHorizontalShift()!=0}.collect{it.getVerticalShift()}.sum() // children at the topmost position&#xd;&#xa;        vShiftOffset = (vShiftOffset == null) ? 0:vShiftOffset&#xd;&#xa;        conn.setInclination([0, vShift-vShiftOffset], [-2*vShiftOffset, -vShift-vShiftOffset])&#xd;&#xa;        aNode.style.edge.type = org.freeplane.features.edge.EdgeStyle.EDGESTYLE_HIDDEN    &#xd;&#xa;    }&#xd;&#xa;    if (!hasNegativeHShift &amp;&amp; hasMovesStyle &amp;&amp; (hasHiddenEdgeFromParent || hasConnectorFromParent)) {&#xd;&#xa;        //aNode.style.name=null&#xd;&#xa;        aNode.style.edge.type= null&#xd;&#xa;        aNode.connectorsIn.findAll{it.getSource().id == aNode.parent.id}.each {&#xd;&#xa;            aNode.removeConnector(it)&#xd;&#xa;        }        &#xd;&#xa;    }&#xd;&#xa;}" ID="ID_1957679840" CREATED="1522496040873" MODIFIED="1522496040892"/>
</node>
<node TEXT="updateNotation.groovy" FOLDED="true" ID="ID_811624548" CREATED="1521565216601" MODIFIED="1521621351330">
<attribute_layout NAME_WIDTH="179.24999465793388 pt" VALUE_WIDTH="166.49999503791346 pt"/>
<attribute NAME="menuTitleKey" VALUE="addon.${name}.updateNotation"/>
<attribute NAME="menuLocation" VALUE="/menu_bar/addons.${name}"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="false"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="false"/>
<node TEXT="import org.freeplane.features.map.MapModel;&#xd;&#xa;import org.freeplane.features.attribute.AttributeRegistry;&#xd;&#xa;import org.freeplane.features.attribute.AttributeRegistryElement;&#xd;&#xa;&#xd;&#xa;import org.freeplane.plugin.script.proxy.ScriptUtils&#xd;&#xa;import groovy.swing.SwingBuilder&#xd;&#xa;import java.awt.FlowLayout as FL&#xd;&#xa;import java.awt.event.ActionEvent;&#xd;&#xa;import java.awt.event.ActionListener;&#xd;&#xa;import java.awt.Dimension;&#xd;&#xa;import java.awt.KeyStroke;&#xd;&#xa;import java.awt.event.KeyEvent;&#xd;&#xa;import java.awt.event.KeyAdapter;&#xd;&#xa;import java.awt.Action;&#xd;&#xa;&#xd;&#xa;import javax.swing.BoxLayout as BXL&#xd;&#xa;import javax.swing.JFrame&#xd;&#xa;import javax.swing.AbstractAction;&#xd;&#xa;import javax.swing.Action;&#xd;&#xa;import javax.swing.BoxLayout;&#xd;&#xa;import javax.swing.JComponent;&#xd;&#xa;import javax.swing.JList;&#xd;&#xa;import javax.swing.JPanel;&#xd;&#xa;import javax.swing.KeyStroke;&#xd;&#xa;import groovy.transform.Field&#xd;&#xa;&#xd;&#xa;import ChessTree.Notation&#xd;&#xa;import ChessTree.NotationTranslator&#xd;&#xa;&#xd;&#xa;/*************/&#xd;&#xa;/** Globals **/&#xd;&#xa;/*************/&#xd;&#xa;SUPPORTED_NUMBERING = [&quot;None&quot;, &quot;For white only&quot;, &quot;For both&quot;]&#xd;&#xa;&#xd;&#xa;SUPPORTED_LANGUAGES = [&quot;sym&quot;:&quot;Symbolic&quot;, &quot;eng&quot;:&quot;English&quot;, &quot;fre&quot;:&quot;French&quot;, &quot;hun&quot;:&quot;Hungarian&quot;]&#xd;&#xa;&#xd;&#xa;DICTIONARY = [&quot;white&quot; : [&#xd;&#xa;    [&quot;sym&quot;:&quot;\u2654&quot;, &quot;eng&quot;:&quot;K&quot;, &quot;fre&quot;:&quot;R&quot;, &quot;hun&quot;:&quot;K&quot; ], // &#x2654;&#xd;&#xa;    [&quot;sym&quot;:&quot;\u2655&quot;, &quot;eng&quot;:&quot;Q&quot;, &quot;fre&quot;:&quot;D&quot;, &quot;hun&quot;:&quot;V&quot; ], // &#x2655;&#xd;&#xa;    [&quot;sym&quot;:&quot;\u2656&quot;, &quot;eng&quot;:&quot;R&quot;, &quot;fre&quot;:&quot;T&quot;, &quot;hun&quot;:&quot;B&quot; ], // &#x2656;&#xd;&#xa;    [&quot;sym&quot;:&quot;\u2657&quot;, &quot;eng&quot;:&quot;B&quot;, &quot;fre&quot;:&quot;F&quot;, &quot;hun&quot;:&quot;F&quot; ], // &#x2657;&#xd;&#xa;    [&quot;sym&quot;:&quot;\u2658&quot;, &quot;eng&quot;:&quot;N&quot;, &quot;fre&quot;:&quot;C&quot;, &quot;hun&quot;:&quot;H&quot; ], // &#x2658;&#xd;&#xa;    [&quot;sym&quot;:&quot;&quot;, &quot;eng&quot;:&quot;&quot;, &quot;fre&quot;:&quot;&quot;, &quot;hun&quot;:&quot;&quot; ]           // &#x2659;&#xd;&#xa;    ],&#xd;&#xa;    &quot;black&quot; : [&#xd;&#xa;    [&quot;sym&quot;:&quot;\u265A&quot;, &quot;eng&quot;:&quot;K&quot;, &quot;fre&quot;:&quot;R&quot;, &quot;hun&quot;:&quot;K&quot; ], // &#x265a;&#xd;&#xa;    [&quot;sym&quot;:&quot;\u265B&quot;, &quot;eng&quot;:&quot;Q&quot;, &quot;fre&quot;:&quot;D&quot;, &quot;hun&quot;:&quot;V&quot; ], // &#x265b;&#xd;&#xa;    [&quot;sym&quot;:&quot;\u265C&quot;, &quot;eng&quot;:&quot;R&quot;, &quot;fre&quot;:&quot;T&quot;, &quot;hun&quot;:&quot;B&quot; ], // &#x265c;&#xd;&#xa;    [&quot;sym&quot;:&quot;\u265D&quot;, &quot;eng&quot;:&quot;B&quot;, &quot;fre&quot;:&quot;F&quot;, &quot;hun&quot;:&quot;F&quot; ], // &#x265d;&#xd;&#xa;    [&quot;sym&quot;:&quot;\u265E&quot;, &quot;eng&quot;:&quot;N&quot;, &quot;fre&quot;:&quot;C&quot;, &quot;hun&quot;:&quot;H&quot; ], // &#x265e;&#xd;&#xa;    [&quot;sym&quot;:&quot;&quot;, &quot;eng&quot;:&quot;&quot;, &quot;fre&quot;:&quot;&quot;, &quot;hun&quot;:&quot;&quot; ]           // &#x265f;&#xd;&#xa;    ]]&#xd;&#xa;&#xd;&#xa;ROOT = this.node.map.root&#xd;&#xa;ROOT_MOVENUMBER = ROOT[&quot;MoveNumber&quot;].toInteger()&#xd;&#xa;ChessTreeProperties = this.node.map.getStorage()&#xd;&#xa;&#xd;&#xa;if (ChessTreeProperties.keySet().contains(&quot;chesstree_language&quot;)) {&#xd;&#xa;    LANGUAGE_CURRENT = ChessTreeProperties[&quot;chesstree_language&quot;]&#xd;&#xa;} else {&#xd;&#xa;    ChessTreeProperties[&quot;chesstree_language&quot;] = &quot;eng&quot;&#xd;&#xa;    LANGUAGE_CURRENT = &quot;eng&quot;&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;if (!SUPPORTED_LANGUAGES.containsKey(LANGUAGE_CURRENT)) {&#xd;&#xa;    return 0 // no translation in updateNotation.groovy script for LANGUAGE_CURRENT&#xd;&#xa;}&#xd;&#xa;// Supported language for translation&#xd;&#xa;SUPPORTED_LANGUAGES.remove(LANGUAGE_CURRENT)&#xd;&#xa;&#xd;&#xa;/*****************/&#xd;&#xa;/**** Settings ***/ &#xd;&#xa;/*****************/&#xd;&#xa;&#xd;&#xa;/* Build Dialog window */&#xd;&#xa;def s = new SwingBuilder()&#xd;&#xa;s.setVariable(&apos;myDialog-properties&apos;,[:])&#xd;&#xa;def vars = s.variables&#xd;&#xa;def disableItem(item) {item.enabled = !item.enabled}&#xd;&#xa;def dial = s.dialog(title:&quot;Settings for updating notation&quot;, id:&apos;myDialog&apos;, modal:true, &#xd;&#xa;            locationRelativeTo:ui.frame, owner:ui.frame, defaultCloseOperation:JFrame.DISPOSE_ON_CLOSE, &#xd;&#xa;            preferredSize: [280, 180], pack:true, show:true) {&#xd;&#xa;    panel(id:&apos;pMain&apos;) {&#xd;&#xa;        boxLayout(axis:BXL.Y_AXIS)&#xd;&#xa;        /* &#xd;&#xa;        Text: Current language is ___. Check tooltip if you don&apos;t agree. &#xd;&#xa;        Tooltip: If the language of notation in the mindmap is inconsistent you should edit the mindmap manually to make its language consistent. &#xd;&#xa;        Otherwise change below settings and click on &quot;Change settings&quot;. It affects settings saved in Mindmap properties, Mindmap content will not change. &#xd;&#xa;        */&#xd;&#xa;        panel(alignmentX:0f) {&#xd;&#xa;            flowLayout(alignment:FL.LEFT)&#xd;&#xa;            label(&apos;Language&apos;, preferredSize: [60, 24], mouseClicked:{disableItem(guiCategory)})&#xd;&#xa;&#x9;&#x9;&#x9;comboBox(id: &apos;guiLanguage&apos;, preferredSize: [100, 24], editable:true,&#xd;&#xa;&#x9;&#x9;&#x9;&#x9;items:SUPPORTED_LANGUAGES.collect{it.value}, /*selectedItem:&quot;Symbolic&quot; */) &#xd;&#xa;        }  &#x9;&#x9;&#xd;&#xa;        panel(alignmentX:0f) {&#xd;&#xa;            flowLayout(alignment:FL.LEFT)&#xd;&#xa;            label(&apos;Numbering&apos;, preferredSize: [60, 24], mouseClicked:{disableItem(guiCategory)})&#xd;&#xa;&#x9;&#x9;&#x9;comboBox(id: &apos;guiNumbering&apos;, preferredSize: [100, 24], editable:true,&#xd;&#xa;&#x9;&#x9;&#x9;&#x9;items:SUPPORTED_NUMBERING, selectedItem:&quot;None&quot;) &#xd;&#xa;        }  &#x9;&#x9;&#xd;&#xa;        panel(alignmentX:0f) {&#xd;&#xa;            flowLayout(alignment:FL.LEFT)&#xd;&#xa;            button(&apos;Translate&apos;, preferredSize:[120, 24],&#xd;&#xa;                   actionPerformed:{&#xd;&#xa;                       vars.dialogResult = &apos;translate&apos;&#xd;&#xa;                       dispose()&#xd;&#xa;            })&#xd;&#xa;            button(&apos;Change settings&apos;, preferredSize:[120, 24],&#xd;&#xa;                   actionPerformed:{&#xd;&#xa;                       vars.dialogResult = &apos;updateSettings&apos;&#xd;&#xa;                       dispose()&#xd;&#xa;            })&#xd;&#xa;        }&#xd;&#xa;        panel(alignmentX:0f) {&#xd;&#xa;            button(&apos;Cancel&apos;, preferredSize:[120, 24],&#xd;&#xa;                   actionPerformed:{&#xd;&#xa;                       vars.dialogResult = &apos;cancel&apos;&#xd;&#xa;                       dispose()&#xd;&#xa;            })&#xd;&#xa;        }&#xd;&#xa;    }&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;/*************/&#xd;&#xa;/**** Main ***/ &#xd;&#xa;/*************/&#xd;&#xa;logger.createLogger() &#xd;&#xa;&#xd;&#xa;if (vars.dialogResult == &apos;translate&apos;) {&#xd;&#xa;    /* Handle received data */&#xd;&#xa;    l = vars.guiLanguage.getSelectedItem()&#xd;&#xa;    LANGUAGE = SUPPORTED_LANGUAGES.find{it.value==l}.key&#xd;&#xa;    if (LANGUAGE_CURRENT == LANGUAGE) {&#xd;&#xa;        return // no translation is neeeded&#xd;&#xa;    }&#xd;&#xa;    &#xd;&#xa;    translator = new NotationTranslator(DICTIONARY, SUPPORTED_LANGUAGES)&#xd;&#xa;    /* Translate each node */&#xd;&#xa;    c.findAllDepthFirst().findAll{it.hasStyle(&quot;White moves&quot;) || it.hasStyle(&quot;Black moves&quot;)}.each {aNode-&gt;&#xd;&#xa;        text = aNode.getDisplayedText().replaceAll(&quot;\n&quot;,&quot;&quot;)&#xd;&#xa;        if ((text != null) &amp;&amp; (text != &quot;&quot;)) {&#xd;&#xa;            translator.setNotation(text, getNodePlyNumber(aNode)) &#xd;&#xa;            aNode.text = translator.translate(LANGUAGE_CURRENT, LANGUAGE) // pure notation without numbering&#xd;&#xa;        }&#xd;&#xa;        &#xd;&#xa;        &#xd;&#xa;    }    &#xd;&#xa;    &#xd;&#xa;    /* Update properties */&#xd;&#xa;    ChessTreeProperties[&quot;chesstree_language&quot;] = LANGUAGE&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;if (vars.dialogResult == &apos;updateSettings&apos;) {&#xd;&#xa;    l = vars.guiLanguage.getSelectedItem()&#xd;&#xa;    LANGUAGE = SUPPORTED_LANGUAGES.find{it.value==l}.key&#xd;&#xa;&#xd;&#xa;    /* Update properties */&#xd;&#xa;    ChessTreeProperties[&quot;chesstree_language&quot;] = LANGUAGE&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;/*************/&#xd;&#xa;/* Functions */&#xd;&#xa;/*************/&#xd;&#xa;def getNodePlyNumber(node) {&#xd;&#xa;    return node.getNodeLevel(true) + ROOT_MOVENUMBER*2 - 1 &#xd;&#xa;    // true : countHidden&#xd;&#xa;}" ID="ID_1617347639" CREATED="1522496040893" MODIFIED="1522496040894"/>
</node>
<node TEXT="updateOddsPieChart.groovy" FOLDED="true" ID="ID_1656865830" CREATED="1521565216602" MODIFIED="1521567273455">
<attribute_layout VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="menuTitleKey" VALUE="addon.${name}.updateOddsPieChart"/>
<attribute NAME="menuLocation" VALUE="/menu_bar/addons.${name}"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="true"/>
<node TEXT="/*************/&#xd;&#xa;/** Globals **/&#xd;&#xa;/*************/&#xd;&#xa;&#xd;&#xa;ROOT = this.node.map.root&#xd;&#xa;mapfile=this.node.map.file&#xd;&#xa;mapfilePath = mapfile.parent.replace(&quot;\\&quot;, &quot;/&quot;)&#xd;&#xa;mapfileName = mapfile.name.lastIndexOf(&apos;.&apos;).with {it != -1 ? mapfile.name[0..&lt;it] : mapfile.name}&#xd;&#xa;imgAbsPath = mapfilePath + &quot;/img_&quot; + mapfileName&#xd;&#xa;imgRelPath = &quot;./img_&quot; + mapfileName&#xd;&#xa;&#xd;&#xa;dir = new File(imgAbsPath)&#xd;&#xa;if (!dir.exists()) {&#xd;&#xa;    dir.mkdir()&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;/*************/&#xd;&#xa;/**** Main ***/ &#xd;&#xa;/*************/&#xd;&#xa;&#xd;&#xa;ROOT.findAllDepthFirst().each {&#xd;&#xa;    aNode = it    &#xd;&#xa;    /* Update edge based on [&quot;Freq&quot;] */&#xd;&#xa;    if (aNode.attributes.containsKey(&quot;Freq&quot;)) {&#xd;&#xa;        updateEdge(aNode);&#xd;&#xa;    }&#xd;&#xa;&#xd;&#xa;    /* Update pie chart for winning odds based on [&quot;Odds&quot;] */&#xd;&#xa;    if (aNode.attributes.containsKey(&quot;Odds&quot;)) {&#xd;&#xa;        if (!(aNode.children.findAll{it.style.name==&quot;Explanation&quot;}?.collect{it.getHtmlText()}[0]?.contains(&quot;&lt;img&quot;))) {&#xd;&#xa;            /* [&quot;Odds&quot;] order: white, black, draw*/&#xd;&#xa;            //updateOddsPieChart(aNode)&#xd;&#xa;        }&#xd;&#xa;    }&#xd;&#xa;    &#xd;&#xa;    /* Change edge to connector for &quot;(un)wrapped&quot; nodes (with negative (positive) horizontal shift) &#xd;&#xa;    with &quot;*moves&quot; style */&#xd;&#xa;    updateNodeConnector(aNode)&#xd;&#xa;&#xd;&#xa;    /* Update Notation from [&quot;Language&quot;] to [&quot;LanguagePrev&quot;] */    &#xd;&#xa;    //updateNotation(aNode)&#xd;&#xa;&#xd;&#xa;    &#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;/*************/&#xd;&#xa;/* Functions */&#xd;&#xa;/*************/&#xd;&#xa;&#xd;&#xa;/*&#xd;&#xa;Google chart API:&#xd;&#xa;https://developers.google.com/chart/image/docs/gallery/pie_charts#gcharts_chart_margins&#xd;&#xa;*/&#xd;&#xa;def updateOddsPieChart(aNode) {&#xd;&#xa;    /* [&quot;Odds&quot;] order: white, black, draw*/&#xd;&#xa;    odds=aNode[&quot;Odds&quot;].split(&quot;,&quot;)&#xd;&#xa;   &#xd;&#xa;    chartData=odds.reverse().join(&quot;,&quot;) /* chartData order: draw, black, white*/&#xd;&#xa;   &#xd;&#xa;    chartLabels = &quot;|&quot; + odds.reverse()[1..2].join(&quot;|&quot;) // only white and black&#xd;&#xa;    // chartLabels = odds.reverse().join(&quot;|&quot;)&#xd;&#xa;    chartRotation =  -Math.PI * ( 0.5  + odds[2].toFloat()/100.0)&#xd;&#xa;   &#xd;&#xa;    chartURL = &quot;&quot;&quot;https://chart.googleapis.com/chart&quot;&quot;&quot; +&#xd;&#xa;            &quot;&quot;&quot;?chs=120x50&amp;cht=p&quot;&quot;&quot; +&#xd;&#xa;            &quot;&quot;&quot;&amp;chd=t:${chartData}&quot;&quot;&quot; +&#xd;&#xa;            &quot;&quot;&quot;&amp;chl=${chartLabels}&quot;&quot;&quot; +&#xd;&#xa;            &quot;&quot;&quot;&amp;chco=555555|000000|DDDDDD&quot;&quot;&quot; +&#xd;&#xa;            &quot;&quot;&quot;&amp;chp=${chartRotation}&quot;&quot;&quot; +&#xd;&#xa;            //&quot;&quot;&quot;&amp;chdlp=b|2,1&amp;chdl=${chartLabels}&quot;&quot;&quot; +&#xd;&#xa;            &quot;&quot;&quot;&amp;chma=0,0,0,0|0,0&quot;&quot;&quot; +&#xd;&#xa;            &quot;&quot;&quot;&quot;&quot;&quot;&#xd;&#xa;    // println chartURL&#xd;&#xa;   &#xd;&#xa;    oddsFileAbs = &quot;${imgAbsPath}/odds_${aNode.id}.png&quot;&#xd;&#xa;    oddsFileRel = &quot;${imgRelPath}/odds_${aNode.id}.png&quot;&#xd;&#xa;    file = new File(oddsFileAbs).newOutputStream() &#xd;&#xa;    file &lt;&lt; new URL(chartURL).openStream()&#xd;&#xa;    file.close()&#xd;&#xa;   &#xd;&#xa;    aExplanation = aNode.createChild()&#xd;&#xa;    aExplanation.style.setName(&quot;Explanation&quot;)&#xd;&#xa;    aExplanation.text=&quot;&quot;&quot;&lt;html&gt;&lt;body&gt;&#xd;&#xa;    &lt;img src=&quot;${oddsFileRel}&quot;&gt;&#xd;&#xa;    &lt;/body&gt;&lt;/html&gt;&quot;&quot;&quot;&#xd;&#xa;    aExplanation.setFree(true)&#xd;&#xa;}" ID="ID_972660721" CREATED="1522496040894" MODIFIED="1522496040894"/>
</node>
<node TEXT="pasteBranch.groovy" FOLDED="true" ID="ID_1708118480" CREATED="1522494712280" MODIFIED="1522494830917">
<attribute_layout NAME_WIDTH="146.2499956414105 pt" VALUE_WIDTH="134.9999959766866 pt"/>
<attribute NAME="menuTitleKey" VALUE="addon.${name}.pasteBranch"/>
<attribute NAME="menuLocation" VALUE="/menu_bar/addons.${name}"/>
<attribute NAME="executionMode" VALUE="on_single_node"/>
<attribute NAME="keyboardShortcut" VALUE=""/>
<attribute NAME="execute_scripts_without_asking" VALUE="true"/>
<attribute NAME="execute_scripts_without_file_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_write_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_exec_restriction" VALUE="true"/>
<attribute NAME="execute_scripts_without_network_restriction" VALUE="true"/>
<node TEXT="import org.freeplane.plugin.script.proxy.ScriptUtils&#xd;&#xa;import groovy.swing.SwingBuilder&#xd;&#xa;//import groovy.io.File&#xd;&#xa;import groovy.io.FileType&#xd;&#xa;&#xd;&#xa;import java.awt.FlowLayout as FL&#xd;&#xa;import java.awt.event.ActionEvent;&#xd;&#xa;import java.awt.event.ActionListener;&#xd;&#xa;import java.awt.Dimension;&#xd;&#xa;import java.awt.KeyStroke;&#xd;&#xa;import java.awt.event.KeyEvent;&#xd;&#xa;import java.awt.event.KeyAdapter;&#xd;&#xa;import java.awt.Action;&#xd;&#xa;import java.awt.Font;&#xd;&#xa;&#xd;&#xa;import javax.swing.BoxLayout as BXL&#xd;&#xa;import javax.swing.JFrame&#xd;&#xa;import javax.swing.AbstractAction;&#xd;&#xa;import javax.swing.Action;&#xd;&#xa;import javax.swing.BoxLayout;&#xd;&#xa;import javax.swing.JComponent;&#xd;&#xa;import javax.swing.JList;&#xd;&#xa;import javax.swing.JPanel;&#xd;&#xa;import javax.swing.KeyStroke;&#xd;&#xa;import javax.swing.JScrollPane&#xd;&#xa;import javax.swing.JFileChooser;&#xd;&#xa;&#xd;&#xa;import java.awt.Toolkit&#xd;&#xa;import java.awt.datatransfer.Clipboard&#xd;&#xa;import java.awt.datatransfer.DataFlavor&#xd;&#xa;import java.awt.datatransfer.StringSelection&#xd;&#xa;&#xd;&#xa;import ChessTree.Notation&#xd;&#xa;import ChessTree.NotationTranslator&#xd;&#xa;&#xd;&#xa;/*************/&#xd;&#xa;/** Globals **/&#xd;&#xa;/*************/&#xd;&#xa;SUPPORTED_LANGUAGES = [&quot;sym&quot;:&quot;Symbolic&quot;, &quot;eng&quot;:&quot;English&quot;, &quot;fre&quot;:&quot;French&quot;, &quot;hun&quot;:&quot;Hungarian&quot;]&#xd;&#xa;DICTIONARY = [&quot;white&quot; : [&#xd;&#xa;    [&quot;sym&quot;:&quot;?&quot;, &quot;eng&quot;:&quot;K&quot;, &quot;fre&quot;:&quot;R&quot;, &quot;hun&quot;:&quot;K&quot; ],&#xd;&#xa;    [&quot;sym&quot;:&quot;?&quot;, &quot;eng&quot;:&quot;Q&quot;, &quot;fre&quot;:&quot;D&quot;, &quot;hun&quot;:&quot;V&quot; ],&#xd;&#xa;    [&quot;sym&quot;:&quot;?&quot;, &quot;eng&quot;:&quot;R&quot;, &quot;fre&quot;:&quot;T&quot;, &quot;hun&quot;:&quot;B&quot; ],&#xd;&#xa;    [&quot;sym&quot;:&quot;?&quot;, &quot;eng&quot;:&quot;B&quot;, &quot;fre&quot;:&quot;F&quot;, &quot;hun&quot;:&quot;F&quot; ],&#xd;&#xa;    [&quot;sym&quot;:&quot;?&quot;, &quot;eng&quot;:&quot;N&quot;, &quot;fre&quot;:&quot;C&quot;, &quot;hun&quot;:&quot;H&quot; ],&#xd;&#xa;    [&quot;sym&quot;:&quot;&quot;, &quot;eng&quot;:&quot;&quot;, &quot;fre&quot;:&quot;&quot;, &quot;hun&quot;:&quot;&quot; ] // pawn for fun: ?&#xd;&#xa;    ],&#xd;&#xa;    &quot;black&quot; : [&#xd;&#xa;    [&quot;sym&quot;:&quot;?&quot;, &quot;eng&quot;:&quot;K&quot;, &quot;fre&quot;:&quot;R&quot;, &quot;hun&quot;:&quot;K&quot; ],&#xd;&#xa;    [&quot;sym&quot;:&quot;?&quot;, &quot;eng&quot;:&quot;Q&quot;, &quot;fre&quot;:&quot;D&quot;, &quot;hun&quot;:&quot;V&quot; ],&#xd;&#xa;    [&quot;sym&quot;:&quot;?&quot;, &quot;eng&quot;:&quot;R&quot;, &quot;fre&quot;:&quot;T&quot;, &quot;hun&quot;:&quot;B&quot; ],&#xd;&#xa;    [&quot;sym&quot;:&quot;?&quot;, &quot;eng&quot;:&quot;B&quot;, &quot;fre&quot;:&quot;F&quot;, &quot;hun&quot;:&quot;F&quot; ],&#xd;&#xa;    [&quot;sym&quot;:&quot;?&quot;, &quot;eng&quot;:&quot;N&quot;, &quot;fre&quot;:&quot;C&quot;, &quot;hun&quot;:&quot;H&quot; ],&#xd;&#xa;    [&quot;sym&quot;:&quot;&quot;, &quot;eng&quot;:&quot;&quot;, &quot;fre&quot;:&quot;&quot;, &quot;hun&quot;:&quot;&quot; ] // pawn for fun: ?&#xd;&#xa;    ]]&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;ChessTreeProperties = this.node.map.getStorage()&#xd;&#xa;&#xd;&#xa;LANGUAGE_CURRENT = ChessTreeProperties[&quot;chesstree_language&quot;]&#xd;&#xa;&#xd;&#xa;NUMBERING = [&quot;None&quot;, &quot;For white only&quot;, &quot;For both&quot;]&#xd;&#xa;&#xd;&#xa;/* CONSTANTS */ &#xd;&#xa;ROOT = this.node.map.root&#xd;&#xa;&#xd;&#xa;if (!ROOT.attributes.containsKey(&quot;MoveNumber&quot;)) {&#xd;&#xa;    ROOT[&quot;MoveNumber&quot;] = 1&#xd;&#xa;} else {&#xd;&#xa;    if (!(ROOT[&quot;MoveNumber&quot;] ==~ /\d+/)) {&#xd;&#xa;        ROOT[&quot;MoveNumber&quot;] = 1&#xd;&#xa;    } else {&#xd;&#xa;        if (ROOT[&quot;MoveNumber&quot;].toInteger() &lt; 1) {&#xd;&#xa;            ROOT[&quot;MoveNumber&quot;] = 1&#xd;&#xa;        }&#xd;&#xa;    }&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;ROOT_MOVENUMBER = ROOT[&quot;MoveNumber&quot;].toInteger()&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;/* FUNCTIONS */&#xd;&#xa;&#xd;&#xa;/* Static functions for ClipBoard handling */ &#xd;&#xa;//static void setClipboardContents(final String contents){    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(contents), null)    }&#xd;&#xa;static String getClipboardContents(){    return Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor)    }&#xd;&#xa;&#xd;&#xa;def showPGNFileChooser() {&#xd;&#xa;    if(guiPGNFolderRB.selected) {&#xd;&#xa;        JFileChooser chooser = new JFileChooser();&#xd;&#xa;        chooser.setCurrentDirectory(new java.io.File(&quot;.&quot;));&#xd;&#xa;        chooser.setDialogTitle(&quot;Choose directory containing PGN files...&quot;);&#xd;&#xa;        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);&#xd;&#xa;        chooser.setAcceptAllFileFilterUsed(false);&#xd;&#xa;        &#xd;&#xa;        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {&#xd;&#xa;            return chooser.getCurrentDirectory()&#xd;&#xa;        } else {&#xd;&#xa;            return &quot;&quot;&#xd;&#xa;        }&#xd;&#xa;    } else {&#xd;&#xa;        return &quot;&quot;&#xd;&#xa;    }&#xd;&#xa;&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;def switchPGNinput() {&#xd;&#xa;    guiPGNClipboard.editable = guiPGNClipboardRB.selected    &#xd;&#xa;    guiPGNClipboard.enabled = guiPGNClipboardRB.selected&#xd;&#xa;    guiPGNFolder.editable = guiPGNFolderRB.selected&#xd;&#xa;    guiPGNFolder.enabled = guiPGNFolderRB.selected    &#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;def getNodePlyNumber(node) {&#xd;&#xa;    return node.getNodeLevel(true) + ROOT_MOVENUMBER*2 - 1&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;/****************/&#xd;&#xa;/**** M A I N ***/&#xd;&#xa;/****************/&#xd;&#xa;&#xd;&#xa;/* Build Dialog window */&#xd;&#xa;def s = new SwingBuilder()&#xd;&#xa;s.setVariable(&apos;myDialog-properties&apos;,[:])&#xd;&#xa;def vars = s.variables&#xd;&#xa;def disableItem(item) {vars.guiPGNClip.editable = false}&#xd;&#xa;&#xd;&#xa;def dial = s.dialog(title:&quot;Paste branch ...&quot;, id:&apos;myDialog&apos;, modal:true, locationRelativeTo:ui.frame, owner:ui.frame, defaultCloseOperation:JFrame.DISPOSE_ON_CLOSE, pack:true, show:true) {&#xd;&#xa;    panel(id:&apos;pMain&apos;) {&#xd;&#xa;        boxLayout(axis:BXL.Y_AXIS)&#xd;&#xa;                &#xd;&#xa;        guiPGNSource = buttonGroup();&#xd;&#xa;        panel(alignmentX:0f) {&#xd;&#xa;            flowLayout(alignment:FL.LEFT)&#xd;&#xa;            guiPGNClipboardRB = radioButton(preferredSize: [150, 20], text:&quot;PGN from ClipBoard&quot;, buttonGroup:guiPGNSource, selected:true, mouseClicked: {switchPGNinput()});&#xd;&#xa;            scrollPane(horizontalScrollBarPolicy:JScrollPane.HORIZONTAL_SCROLLBAR_NEVER, verticalScrollBarPolicy:JScrollPane.VERTICAL_SCROLLBAR_ALWAYS) {&#xd;&#xa;                guiPGNClipboard = textArea( id:&apos;guiPGNClip&apos;, columns: 60, rows: 6, font: new Font(&quot;Consolas&quot;, Font.PLAIN, 11), text: getClipboardContents(), wrapStyleWord:true, lineWrap:true)&#xd;&#xa;            }&#xd;&#xa;        }  &#x9;&#xd;&#xa;        panel(alignmentX:0f) {&#xd;&#xa;            flowLayout(alignment:FL.LEFT)            &#xd;&#xa;            guiPGNFolderRB = radioButton(preferredSize: [150, 20], text:&quot;PGN from folder&quot;, buttonGroup:guiPGNSource, mouseClicked: {switchPGNinput()});&#xd;&#xa;            guiPGNFolder = textField(columns:60, font: new Font(&quot;Consolas&quot;, Font.PLAIN, 11), mouseClicked: { guiPGNFolder.text = showPGNFileChooser() }, editable: guiPGNFolderRB.selected)    &#xd;&#xa;            &#xd;&#xa;        }&#xd;&#xa;        panel(alignmentX:0f) {&#xd;&#xa;            flowLayout(alignment:FL.LEFT)&#xd;&#xa;            label(&apos;Language&apos;, preferredSize: [60, 24])&#xd;&#xa;&#x9;&#x9;&#x9;comboBox(id: &apos;guiLanguage&apos;, preferredSize: [100, 24], editable:true,&#xd;&#xa;&#x9;&#x9;&#x9;&#x9;items:SUPPORTED_LANGUAGES.collect{it.value}, selectedItem:SUPPORTED_LANGUAGES[LANGUAGE_CURRENT]) &#xd;&#xa;        }         &#xd;&#xa;        panel(alignmentX:0f) {&#xd;&#xa;            flowLayout(alignment:FL.LEFT)&#xd;&#xa;            button(&apos;Paste&apos;, preferredSize:[110, 24],&#xd;&#xa;                   actionPerformed:{&#xd;&#xa;                       vars.dialogResult = &apos;paste&apos;&#xd;&#xa;                       dispose()&#xd;&#xa;            })&#xd;&#xa;            button(&apos;Cancel&apos;, preferredSize:[120, 24],&#xd;&#xa;                   actionPerformed:{&#xd;&#xa;                       vars.dialogResult = &apos;cancel&apos;&#xd;&#xa;                       dispose()&#xd;&#xa;            })&#xd;&#xa;        }&#xd;&#xa;        panel(alignmentX:0f) {&#xd;&#xa;        }&#xd;&#xa;    }&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;/* Handle received data */&#xd;&#xa;pgn = &quot;&quot;&#xd;&#xa;if (vars.dialogResult == &apos;paste&apos;) {&#xd;&#xa;&#x9;/* Update attributes */&#xd;&#xa;    PGN_LANGUAGE = SUPPORTED_LANGUAGES.find{it.value == vars.guiLanguage.getSelectedItem()}.key&#xd;&#xa;    switch (guiPGNSource.getSelection()) {&#xd;&#xa;        case (guiPGNClipboardRB.model):&#xd;&#xa;            pgn = guiPGNClipboard.text&#xd;&#xa;            break;&#xd;&#xa;        case (guiPGNFolderRB.model):&#xd;&#xa;            dir = new File(guiPGNFolder.text)&#xd;&#xa;            if (dir.path != &quot;&quot;) {&#xd;&#xa;                dir.eachDirRecurse() { dir -&gt;  &#xd;&#xa;                    dir.eachFileMatch(~/.*.pgn/) { file -&gt;  &#xd;&#xa;                        pgn += new File(file.getPath()).text&#xd;&#xa;                    }  &#xd;&#xa;                }  &#xd;&#xa;            } // else no folder selected&#xd;&#xa;            &#xd;&#xa;            break;&#xd;&#xa;        default: break;&#xd;&#xa;    }&#xd;&#xa;    &#xd;&#xa;&#xd;&#xa;} else {&#xd;&#xa;    return;&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;/* Initialization */&#xd;&#xa;pgnNotation = new Notation(pgn)&#xd;&#xa;nodeNotation = new Notation(this.node.getDisplayedText(), getNodePlyNumber(this.node))&#xd;&#xa;&#xd;&#xa;/* Determine starting node */&#xd;&#xa;// First check this.node&#xd;&#xa;currentNode = null&#xd;&#xa;if ((pgnNotation.getPlyNumber() != nodeNotation.getPlyNumber()) || &#xd;&#xa;    (pgnNotation.getMove() != nodeNotation.getMove())) {&#xd;&#xa;    currentNode = c.findAll().find{ //breadth first order&#xd;&#xa;        nodeNotation.set(it.getDisplayedText(), getNodePlyNumber(it))&#xd;&#xa;        if (pgnNotation.getPlyNumber() &lt; nodeNotation.getPlyNumber()) {&#xd;&#xa;            return false // node&apos;s plyNumber is over notation&apos;s (breadth first!)&#xd;&#xa;        }&#xd;&#xa;        if ((pgnNotation.getPlyNumber() == nodeNotation.getPlyNumber()) &amp;&amp;&#xd;&#xa;            (pgnNotation.getMove() == nodeNotation.getMove())) {&#xd;&#xa;            return true // found&#xd;&#xa;        } else {&#xd;&#xa;            return false // not found&#xd;&#xa;        }&#xd;&#xa;    }&#xd;&#xa;} else {&#xd;&#xa;    currentNode = this.node&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;if (currentNode == null) {&#xd;&#xa;    return -1 // no matching node found&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;// printNotation()&#xd;&#xa;pgn = pgnNotation.getRemainingText()&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;translator = new NotationTranslator(DICTIONARY, SUPPORTED_LANGUAGES)&#xd;&#xa;&#xd;&#xa;translationNeeded = (PGN_LANGUAGE != LANGUAGE_CURRENT)&#xd;&#xa;&#xd;&#xa;/* Walk through PGN */&#xd;&#xa;&#xd;&#xa;while (pgn.length() &gt; 0) {&#xd;&#xa;    pgnNotation.set(pgn)&#xd;&#xa;    &#xd;&#xa;    if (pgnNotation.getMove() == &quot;&quot;) break;&#xd;&#xa;    &#xd;&#xa;    //parse comments for Odds, Freq, Opening&#xd;&#xa;    comments = pgnNotation.getComment()&#xd;&#xa;    odds = opening = freq = &quot;&quot;&#xd;&#xa;    &#xd;&#xa;    &#xd;&#xa;    odds = (comments =~ /(?i)\s*odds\s*:\s*(\d+)\s*,\s*(\d+)\s*,\s*(\d+)\s*;/)&#xd;&#xa;    if (odds.count&gt;0) {&#xd;&#xa;        comments = comments.replace(odds[0][0], &quot;&quot;)&#xd;&#xa;        odds = &quot;${odds[0][1]},${odds[0][2]},${odds[0][3]}&quot;&#xd;&#xa;    } else {&#xd;&#xa;        odds = &quot;&quot;&#xd;&#xa;    }&#xd;&#xa;    &#xd;&#xa;    freq = (comments =~ /(?i)\s*freq\s*:\s*(\d+)\s*;/)&#xd;&#xa;    if (freq.count&gt;0) {&#xd;&#xa;        comments = comments.replace(freq[0][0], &quot;&quot;)&#xd;&#xa;        freq = &quot;${freq[0][1]}&quot;&#xd;&#xa;    } else {&#xd;&#xa;        freq = &quot;&quot;&#xd;&#xa;    }&#xd;&#xa;    &#xd;&#xa;    opening = (comments =~ /(?i)\s*opening\s*:\s*([^;]+)\s*;/)&#xd;&#xa;    if (opening.count&gt;0) {&#xd;&#xa;        comments = comments.replace(opening[0][0], &quot;&quot;)&#xd;&#xa;        opening = &quot;${opening[0][1]}&quot;&#xd;&#xa;    } else {&#xd;&#xa;        opening = &quot;&quot;&#xd;&#xa;    }&#xd;&#xa;    &#xd;&#xa;    //println pgnNotation.getMoveNumber() + &quot; _ &quot; + pgnNotation.getMove() + &quot; _ &quot; + pgnNotation.getComment()&#xd;&#xa;    //println &quot;      &quot; + odds + &quot; _ &quot; + freq + &quot; _ &quot; + opening&#xd;&#xa;&#xd;&#xa;    // search for matching node for current pgn move &#xd;&#xa;    matchingChild = currentNode.children.find {&#xd;&#xa;        nodeNotation.set(it.getDisplayedText(), getNodePlyNumber(it))&#xd;&#xa;        if ((pgnNotation.getPlyNumber() == nodeNotation.getPlyNumber()) &amp;&amp;&#xd;&#xa;            (pgnNotation.getMove() == nodeNotation.getMove())) {&#xd;&#xa;            return true // found&#xd;&#xa;        } else {&#xd;&#xa;            return false // not found&#xd;&#xa;        }&#xd;&#xa;        &#xd;&#xa;    }&#xd;&#xa;    &#xd;&#xa;    if (matchingChild == null) {&#xd;&#xa;        // no mathing child found, create it&#xd;&#xa;        currentNode = currentNode.createChild()&#xd;&#xa;        def moveText = pgnNotation.getMove()&#xd;&#xa;        if (translationNeeded) {&#xd;&#xa;            translator.setNotation(moveText, getNodePlyNumber(currentNode))&#xd;&#xa;            moveText = translator.translate(PGN_LANGUAGE, LANGUAGE_CURRENT)&#xd;&#xa;        }&#xd;&#xa;        currentNode.text = moveText&#xd;&#xa;    } else {&#xd;&#xa;        currentNode = matchingChild // matching child found, advance map processing&#xd;&#xa;    }&#xd;&#xa;    &#xd;&#xa;    if (opening != &quot;&quot;) {&#xd;&#xa;        if (currentNode.children.findAll{it.style.name==&quot;Opening&quot;}.size() &gt; 0){&#xd;&#xa;            currentNode.children.findAll{it.style.name==&quot;Opening&quot;}[-1].text = opening&#xd;&#xa;        } else {&#xd;&#xa;            opening = currentNode.createChild(opening)&#xd;&#xa;            opening.style.setName(&quot;Opening&quot;)&#xd;&#xa;        }&#xd;&#xa;    }&#xd;&#xa;    if (odds != &quot;&quot;) {&#xd;&#xa;        currentNode[&quot;Odds&quot;] = odds&#xd;&#xa;        //TODO: update oddsNode&#xd;&#xa;    }&#xd;&#xa;    if (freq != &quot;&quot;) {&#xd;&#xa;        currentNode[&quot;Freq&quot;] = freq&#xd;&#xa;        //TODO: update connector&#xd;&#xa;    }&#xd;&#xa;   &#xd;&#xa;    pgn = pgnNotation.getRemainingText()&#xd;&#xa;    println &quot;*********************\n${pgn}\n&quot;&#xd;&#xa;}&#xd;&#xa;&#xd;&#xa;&#xd;&#xa;return 0" ID="ID_1984657073" CREATED="1522496040895" MODIFIED="1522496040895"/>
</node>
</node>
<node TEXT="lib" POSITION="right" ID="ID_328124690" CREATED="1521562135185" MODIFIED="1522496030007">
<edge COLOR="#7c007c"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      An add-on may contain any number of nodes containing binary files (normally .jar files) to be added to the add-on's classpath.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The immediate child nodes contain the name of the file, e.g. 'mysql-connector-java-5.1.25.jar'). Put the file into a 'lib' subdirectory of the add-on base directory.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The child nodes of these nodes contain the actual files.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- Any lib file will be extracted in &lt;installationbase&gt;/&lt;addonname&gt;/lib.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The files will be processed in the sequence as seen in the map.
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="zips" POSITION="right" ID="ID_188436602" CREATED="1521562135191" MODIFIED="1522496030022">
<edge COLOR="#007c7c"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      An add-on may contain any number of nodes containing zip files.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The immediate child nodes contain a description of the zip. The devtools script releaseAddOn.groovy allows automatic zip creation if the name of this node matches a directory in the current directory.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The child nodes of these nodes contain the actual zip files.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- Any zip file will be extracted in the &lt;installationbase&gt;. Currently, &lt;installationbase&gt; is always Freeplane's &lt;userhome&gt;, e.g. ~/.freeplane/1.3.
    </p>
    <p>
      
    </p>
    <p>
      &#160;- The files will be processed in the sequence as seen in the map.
    </p>
  </body>
</html>
</richcontent>
<node TEXT="templates" FOLDED="true" ID="ID_1849114914" CREATED="1521565216661" MODIFIED="1521565216662">
<node TEXT="UEsDBBQACAgIAIKad0wAAAAAAAAAAAAAAAAfAAAAdGVtcGxhdGVzL3RlbXBsYXRlLkNoZXNzVH&#xa;JlZS5tbe0ZaXPiyPX7VOU/dDRTE5wdhO5jDXZhwDa1HA7Inp0Yr0qWGtCMkFip8bGbzW/Pa10I&#xa;kDGZSW0qlZVrQHS/fvfVb+oLa4kecBi5gd9gpiHGS8/yMeJZheWYkz+9qf+5WjUC9ODiR0Tmbo&#xa;Smroc/ICd49L3AchA9ghau7yDAtHT9GYqCKXm0QozOc2zTMFigOSHL72u1nAYbBavQxtMgnGHW&#xa;xwRVq5SeRUjo3q8INkM8cyMSPqPx5fCj2TSMUffs2uiMG0yEPWwT7FAGETyFQ761wGjUGQNwy+&#xa;i0GwwJV5hBg2a/02BacxxFBjBwFQZLHBIXRxmKLTQPlrfC6KbZu4ZjTC2jU9sk9AL5fnNw3exl&#xa;pF9ipmf5s5U1w4dwgP1ZzsQ+OFDuQXDzlX8QXPS82Cd8cSmzFl32Awcjo/OjAZxLDOoNW81e9+&#xa;+dtjk2PvU65qhz3mCaKxIsLOLaPes5WBHWww/YY8MgIAw6H/baVF1Ty4tAX1147bZNSVV5med4&#xa;nkGtUacZK5SXBV5QNU3jRZ5jUH/Y7p53sw1FkBRNUniROanPg+BLqvi+tRyTZy9XfN0OfMclEA&#xa;GWZ0Z0JyqqZmcXNVtG96aTWbMg08e5SyAaggfwK9Rrjo0UpoAuQ/l55dvEzHFvQcRQVIsmuKkb&#xa;OK5txvpZH0BXnVF3CIIK1MP6ze6g3Rk1GG7DrDmqyA7d5X5yBbiTK3Nw3T8DAoML1EC1ysT5bs&#xa;JWJuyEPTo9qr1/++Qcv7ky+8ObTrxdueWGd1X6UYk/AegfFfYU1q3q/O6Wr2p3p0enT/BvvVBp&#xa;UFxHt5PvJm/vTnOcg2ZCsTJ5N3F+5T+IvwGq258mj3e/ch+E344y6n5ALCrIFTggDv34zOkiWh&#xa;399K7A/Okk+uu7hNHkDdBntJLPEJMVHK/Q1MZShbMzTNpuBBnqGTsGfiKVI9Ro/BNtETyq11Jd&#xa;lWi79oq667W9DhBvb7rcV/rjmWfZX/6r/sj/4Y//v/6Ypu/S9O/gqbXySOaWCei61LyYkuvLvH&#xa;SjaB48mi6AmtBEmHkpinLKU5eYJDBp87IMQpKuHzPJSVAhjo9HWejYtD8g0B+YXlqc16UXyhp0&#xa;OGtm6vFbXOnWAiY1L4GJa5lJAdKYbDABFFcGXQ+658NR3xxfNq/yqL25aF6Zf7tuDoyu8QmiSG&#xa;I5tCRxBzYNfILGgJ8ux7y8TnsZYtCw60OPhK6G467RHQ4aTOjO5iTn5n51f59UwT34cju1hr0h&#xa;BPRbLn5yJKD5L2sukwLbDF3LQ9c+6BYw9sdMyj2t0GdQ2teF3QBaraL1wVczVg7iKwZgHUws14&#xa;sO5UP7BlJrL/s9qFEX3VX9WbP1w8VoeD1om9nWNH6YuOkyAd8FWLvXOTd+DyancBEg0PnHtLAz&#xa;w5lvzF0oGHQhQW57wcrJhZly9A/oJ1GQiDPqtIwEeB/PJaweyngaHqsIh9WvC5AEz0an90JopM&#xa;fL471oqFZnYHRGOzlATlIA6ncH5sdu27iEJY6uPW2nBV7IAitGXts2xD3+xcUhg1Is0EC3m2N4&#xa;GQ973XYCvm7kvbgfT24AGV1elFidPrKuKoqmKJSxvR6TqGmjATnAjZX4+UODaw0Ol9insZVrT+&#xa;Po32ZJ2QqYCwx3atdax3ZRtDzplgu6jtkdiqkk0Jr4h3DeeaLX/LhJ2V89XjdvnMngWv1jpk2B&#xa;S814gGm1zaJziMRZNn1F4n8z6WzdeL+xMO+7P/+vJKRXdbr1a7MBq9E7/bdEXn5ueyKzPSbZgS&#xa;wbJG1Mi16UtjgakUtcIJ118BonKbzEK9LWsENWBEUQZU7dHnbIiijK8Cm9aLbLrWWBFSRQi6Yp&#xa;HKfwAifFUDfjy+65UYBT+UR9qiZLgihoUtaXFkT5AVLUe2sZRMcR3GOs46X16G/cRPM0lsmnKq&#xa;rEC5Iql8gnq7oq7Mon6CChpO0IUpVEVo0lEVRN52VdLBekKicC65okyqKq8UImSWE4RIeWA9qz&#xa;J76ZuV5BVkcsWInnOYHT9e2RFBhDUClPpVZSRE472EpKKpsqyDqYXS6XjUugwEqqImmCrOklVu&#xa;rCncrabxdR0xWNUynj2wLBI2nSHoG2zSKnjqNxogjerGrlrPMcm7CuaCrIB/b/OrNIa7OAonRO&#xa;EoXt4NEEEA8cfse56IYqgYa3VYZ/QXj2jD6DV0/FY+TBN9aPl8lXhCA3+esBJc/zECCSyqsldF&#xa;WIHrmMrgYJSt1JDlbk5Hg1WVY46It20eq8Dgl+x8viDZ4DcTbVtftSoGjvS0eCwPGSXpqOqNFE&#xa;vsQvBEHkZOE/nY6qkpq6lazokqbJaomnF3oPlmU3PH6jLckdRtNlVdKUkmykqTqvloknC4oqKD&#xa;ty8Goaihr4GaQ4/YWIhaSVgKmcKOs6x8di1EPXnttQSDHUUuMTLc/tjtHs9sZURAgJsvBO3iBU&#xa;n2PLOYknIvRXLftZvw+c55N0UnKSDmlo4KD1xRXZlo/u8ffpqGW5DX77/udVQI6HjhMlb3eoit&#xa;wpwk9uRKIPaOliZM+tkKBH1/MAE5phH4cWwQ6yImTBpus5KDbHo0vmqKBylFwZXyEN0f5zKelH&#xa;1wF8wTRG/pcIub4dLBb0f53ielsJQgTK87FNgvAoZ89yPq+imDvbDkIHwL3nDRbqtURtoMdYv/&#xa;VawQyHZaKSF+hW4PtfUEsHCBPvSGrWBwAAYhsAAFBLAQIUABQACAgIAIKad0wT70hq1gcAAGIb&#xa;AAAfAAAAAAAAAAAAAAAAAAAAAAB0ZW1wbGF0ZXMvdGVtcGxhdGUuQ2hlc3NUcmVlLm1tUEsFBg&#xa;AAAAABAAEATQAAACMIAAAAAA==" ID="ID_1474320413" CREATED="1522496040896" MODIFIED="1522496040922"/>
</node>
<node TEXT="lib" FOLDED="true" ID="ID_1750925238" CREATED="1522351097503" MODIFIED="1522351097505">
<node TEXT="UEsDBBQACAgIAIcNf0wAAAAAAAAAAAAAAAARAAAAbGliL0NoZXNzVHJlZS5qYXKdenVsJbzyXZ&#xa;hhw5xsmJmZmfmGmWnDzDd4w8zMzMwMu2HeJBtmZtgkfZ9+VfteK7VVxx7ZluwZ+Z9jn6NRkYeE&#xa;wgSDg4MDi0AOVAD7N8MFgwITt7ZwddVwsbBgVnJyM3GzcXJkMrM3cXX9nAIDK+XzFklZvWW/6P&#xa;VDCKA/K/cipbtgWqWroHnEVkUhPwkPSoIWMt5vkvfAiZV15VDMLuHUNkvKKpN1TaVQVIunwXXl&#xa;9gywuSp2uHrv22g5vbXjv+91Sof2wArsF/Y4ImK/tzz61cN9HUr95f/sD6YSYkQ6Qd+9JFNCWl&#xa;Ml2VpYwXyGCs0YBJdZ/tL2Hg3RZ2ylanBOa6u3BAEDlM3dVbF+V2I1rGw1a6YCxmQAxUTDjZHP&#xa;yFtUHn9EgdBitgov6UIqx+vb0Npc29vauzWRyQEbYltbtizRxufwFzGxcfDVW0KBcyQX9irKxb&#xa;xmS6t4pO6u5D0qv6eCmNErETyA33KWC39YqepVGFzePUpFu/0atpUOWqFKjd5rKYksLQ2jWKqR&#xa;GEi2HnTkPFssQ6PSot7Qx8j+nveQllbRr1cb/9blG+lEJBYwJCMPstouSivoMkCuf3x8qBhMUo&#xa;u3CjjteS29n54SgDuiNJd88IXT8YbPq4wPn2wZfc1GGzv0qJpP7RMp2CbRTI8YFrorp2bup+3U&#xa;6RU17KyIPSGXMMI002cQ5VJoFcdXEM9IMK+s+vsLXSEcT4Et+WP9kLp6XDs+BnG7vuLIzbsEF0&#xa;o8L4FjFUVqQhyMnocSgotA1kPeGKdWDH5BsjrDnjBFHSumKtd2DeKAYNrDqEC79tw4tvquWvpb&#xa;oup94RLKfYEChKyMHs0g7jxdunGNNWPid/GWiVlK6Xs9f721PxgGjexVbKN3HkbKKe46Uo1z2F&#xa;r+qq1j0r452ascbNHuHz7FnyJoqomO9MalRGnDdPBso2d23wh7sh91Y1aQYNKT0vPJeigAiJo9&#xa;1OcUEyHwDKX4hTfWXCMtVtRh/H4OZ2KISwv4l5+R9ZwFbYtngx5GHYIm/hvNyRRrYNRrhShc+C&#xa;cqYMCQfQQWRPsijZ3d1N7dhrR6gvsq9VwMkPQbc6k0RgTFzVDUaQMevuxppBzopyL+9CRPdkEm&#xa;USc0aW0ECllNkSJyNUWJKD/f2DHlLhl6YAnTxTWFldwcFeGSUiKt1KQNkWmNOgRszPHlbfP7yY&#xa;G+h/5KeQPnQJsH+U9ZDx4KbrYRKbWEMu727izEbPKZI7FyrJOJlOzt9ebunVzBVc5ra6aKjOWL&#xa;jb0mCO+5pZbHn4wSTbm5nS38C9n9rZ1RL3dZnh132eR1Rzk9ZbW8ejmvv3gZHBDB6XOk8k5vYH&#xa;9zqxGr+dpsO9tXpJGZWJZIRLW520T58eUMTt75Pxnib5ESyqbauonzLBWHF/NHdO5YG/ITzJjU&#xa;fwQxlFUXj+No0bcuIXO7vYYMQ1C1VrW0CgPvAaUkjXIwMFJ8rwBmYNi42bXKIxMwv8FH2CKYCs&#xa;YSBhvoXpzEe6bJdKjJZLauBcMF4wFzKlDdeUJ3Nzaf1KMmoavpqTwA4RuOCWk6BtFfwDMXSsU8&#xa;i9BfMs3/FWPqOZlJKKLVEXf16ceYNlOw/ejmdMydj0c90T4U66ZHxa+YnWQQ7le7aR9RvbtqHz&#xa;FijBTaCEcfZyntZoUaC/sbkqLMOnVj9xxZgsC6hvQCUYpPbNexd/sVOWQJHwFaw+iHegOn20aD&#xa;PC8px1UQ/+UP/r9p2rPGCZPGhJCZwaGDXjA6B2hGdnrdG/PrmvpWYeDEOQPGZKGybvic0jU/mD&#xa;0xYZLxFEwSFK0IKRuxAsZ7K93MsXR3VR2VzVhyB5Fg3Iz0zLKNw75I2/xmXv/c66OE6iC54P20&#xa;ZIkY1IfxRrrD4zmFWloszXLyu1s9U/f1B4f//L6wE69waLpjqTJQkCCKFmoKQ4kkgHTEmjFbkC&#xa;KKFwqNhM0GGCnIGTSFkcfVYHkhDi1FSmMFzBhDh6YiabECfhkjh8rB2OFpsALGjQVzfQl0bbmX&#xa;awC9jVVtSVPVyIyc7tna6imO1jo62urNXW3BGxoMdYXDIERZ14jtBujWhSQxYBGHzKPipbFwLt&#xa;Plhhe8XaFhrFaDbmWr6FINevIIDyDVFoYTyRZviXVNRE8dALAeZcXE0l8ZldOrXoEHDim4Q8gu&#xa;tovZg09tYBeEopwTGbit6yYOTS3h37Q6NBdhSxPI2hgwFkKjrrBbGzfI0nSYNARZko+MpsvWxo&#xa;pX22RW9+vT4RZ1fu48zXFxtpuvZZYfH1QokQPvVK2s/LVpag6PdP1HQprXiPpkWkgpsAWfNAvo&#xa;qXftc8zG9XPk0TeWZVANIC+XzTHFRhtnctZUNAOSVOHv5ycJ9oqmNHgioyvrVHwNVJgDKrZtlT&#xa;XUMF2L6eDcDtW1M8Q5aQfEVkoi68oK6rMh5k8Q7+sskRxJU3l6AifpSilAc8lmZM4UVdxe8E4C&#xa;b0Tufy0XCuNKAWNUDAUJKwifpFOeCIfUHmVqp8Cv/PxkPndWJpNYuocRTMkmM5ngivTjDsz0eX&#xa;HYdPXPW3GmwgoPytgFTAuhuhHNngNb+LFgBXeKhd1U7o306jCQDm1ZldezVsyD/OdJ/hB63bgt&#xa;v6ClHXCnowp9ZT4USHXCkExmWzSYfK8GGGelpDyCT634mZ+ashmSHa+DRDR7S24CmZcRZ2iPCf&#xa;tqfEJYHM2vC+QwYQeVjEv4UKgeFH1Vb6fAMnqxTT/Y5GO6kPP7CWpiqsKZuf4OF/oqp7pZvMJa&#xa;juA7gbpWOT2wKU4XaiueQpO4tjxPagt68hcd4gpILC/MP0B20Y54AW6NDfYyzSsRH69yevxmDX&#xa;I7XofgaNIxp+7FXpVdCy2/0wdAQFPduqhi9Prqemopl+Pm0YRXhOATnFKuHqQdwIirBsLSOmEj&#xa;w8/OCaHtPJ/CRM+7vZIZ0NMKtHLSlNQ2gsPPDjZnvsHCL82/hLE8XGJ/YZrEqsq8kAvErwcq2O&#xa;CbOZEnvxQnh1P2fNPN3KMmXOEbRSHp/jMhMwQCduFgSG/zfeqG4OyWCrjgJSY8twRPextzD3UU&#xa;ajEfc4cybqfd0JFeHMN/qr5WlTOwgcKB/Tv4i5GrFACF1mjmHeFc+niA+tA5sMaIcg6ZWBfDZd&#xa;QTREqSoCv3ApJbQP+NoHiR9G3rl9ZfTk7ZJRfb7SGjY5/WIwdzJ37oHiwnagdI2wb2DYtRftny&#xa;NhUWOQuJkWjfyj74akGNggrzeqxnDN924TV5dU80E26snc+8ASV64j1bhpLA2cY9sMmjkJ/Rnv&#xa;dhUqORWNeFWspBOtdmlZ8zddb+6f2hlsQFPKcoaLfimBCTSJI00/LOJ6VvcYW3Nha0DiexXhjH&#xa;P83g8vZxTAepww269jgUHlsGyy9eKNQehQ5p1h0G/yTPt9CiC8mDg2Z3XNGFYuIbsphLvOqth4&#xa;xMN9JtCPyGWEfHP8DRjEaF12SGhRfq2hspO+Ga428NyJ5iOczWEqD/FKCn5Bm2ajTLvGD3OY5z&#xa;3zoAbUKBraSxKdt2djSEv7UjhgsboP9IZrAq4Goehey1cLVK+07uvhf11RWmx9QnY78kLJAID8&#xa;S/QPOOxl3vUmNq7JUkVoubX1garc0ajePjJvQtfxYYypyTP72pOHUoGuyjVrBgLAzAHcDgyjPS&#xa;r71kQweuLf3oiqMkip+/BRBZnfAkO5flXvsO4dw9kw8d31kJDXEJiXPWWK/NlPMJr1gbNIF/E9&#xa;5vR8cV8V1EHXjAL5+eQ+V9b0Glyb+nT8Yu5Bb+GaL/WSRdu84Sgdu/E49CMSZD19iA19VwbW2O&#xa;tCs+EzBBHdzaVL1ZgZvLCFsowupTaaWmsEn/L2ent7xKpbGsL/yZZIEXBL1plGKxq1NterhtOi&#xa;rX3MaQLaSXaLGv0216vK02esW5iTgGDjDIqyu5VylNunInDnk8TCJz7pdK7IFUCeTMeDcWC97c&#xa;ce5qkl0x4ZmE2xaS0R5I9Ydr84G9zBNlYh0S2nJ0tPGwq8Xmyazom+tJhElPvL8uIAlB1XVnZi&#xa;h2voxVIq5Yca92tsvqfN7bfqFDd54nMKpJ2lm8hcou0JEZZkiyKO0kv5gFV3keKAE/2YC8C+A5&#xa;tE0wDec0J3CEAjWixoQL7rCk4DXHOAfi9ULfcTW9sUAh7/zi2sSk1miaVtAp4yFtf3oKhofXQM&#xa;WwnmEbP/1peLdOyuPeUTPIWDOnK6YVMsnOMU4YB7tkstW4ie9mj4JnX3JiIObcnTZkhyFph/rI&#xa;XPTpeGY0Oz9NQhcGsj+U6IcbuCMbbyCsZLyZ6iX0NPSGhc3hJraWp53L8RxU8z4Gy9FxVGUwbP&#xa;dLk24kDHe1mZbZBX+5Je6YZ8y/dp7GmQOKgpINYFhG8Q+12v0SI4AaXYegqLMkCTqzmkIA6vAs&#xa;TReN29bdoULfEuM11R39iacFmXyPM25AHowpfLYpxsYGekupF3Xs5Xbf19LdDlpH17xC47I1TY&#xa;UThd45weSCz3TvD8Vi0b608AOj+QQ/cf9inb7KPpI3AAxlJLcFHB5296GegNzbN6sS/6M0J8pc&#xa;p+KoREuuNIz7bUFjTYoNG7kp1incxAuziSv/kXbhxFmOCW6tYwL6F7YUJFMeESRPSrYMWDw293&#xa;CFQRYlPOqZROcRz4QXFMo7HdhX81xlbD+UUdIZTNjbR9+DYcdXx+28IqD/9+8Z5tokMZ7T0uHo&#xa;KfHaYyB1ux7tyTkaz85DXwG5cL/8i4WnXgH5SbLsJuvYd9l22JPn7x/EplkRsJ6/OYYKDzFS4H&#xa;XfaDAin9HKAhmUCqGPORZKixr9ivQCNheLZG2WcHumJJxIlA7Xvb7PYrYkb95hDFtTz3c+t+oF&#xa;qMX/LMfFQZL6DpuuisqUDFdZzluSFwWdVERjKDlvz+w6PZvkMDt/7f3Wu6OakjiYa+1OYj1vJK&#xa;STqeBClZzLjP5H/sE30yuWPMRijlc9hXaIVz3yNHVpZtJjuh6Fnec3/0mm8Ly3JUN2FidngJYi&#xa;pWdK91Q57aLEg9I+omUXmwFwze3ql4plpGL+YG/mlAKaFHuvf3iY42urufc9X+aDVHTP5Pwwmz&#xa;TwkMEiDeCNrfNEddubSubk4t6nP8itl6mI5IQxzE97Zxk3wyLN8lPzCKH4CP1P98iz4b8OLr7e&#xa;QRn1JTEjzVD3Pbf2vO4AvO93G3qc6ZR2xcq1M4mms+MFpi4Ge5xp7ZNBKy8Zbu/AgPyFa/YyXp&#xa;/tDqx2OGTu24CZh0nx4gHGQFYGDgS1Q8VCvU8XXIfCiez6h57XN6/7MhnaOzrJxp7XcPt39o9P&#xa;sX4nQbn5k7syAC0V76j5sVHUtdPDe5xXfBo3pVzUDyV41g/BVleZJeFwvAu8RO77pqPRe8u8ie&#xa;zXKT+03ntebrlUNTTT0k169amRsnRnp+AmEeA8xMJBfhfOF+dP0CFiatjep14GgP9BxQAp7dis&#xa;FbJV4tK4UQD6Sz61AXwMQBwcqA6So5n2vyGxzSyYcCFPxeFq2FG4FyppJyvZ37I5NsZvZUMqHw&#xa;jgUJFnDSiO/8X1pyAey6Z1gqAh6ECx/BOpqt1KDYsteyUfkjgDMTVB+lFGSABV6eUbAku6F34B&#xa;rqco/DYi8V/so1IsEZuNygYWB2oGpW6ktBJBxW2FUItwBYAJDZAz3LGCgxDYGq5cMJWBzClFvY&#xa;RPb1zsTLREoAyEMYO1Z7sKIttnouESQqIccxo0owvypsKSU2wfElsUAtj7QKRlKKqYMEVYHLU2&#xa;DG2C2/3kFi99dQXYTQbTyUMuAXQLVxYQCRiPxXoP1awb9BGzGdpD0+lozHp+MFI6lZ06BdtuJy&#xa;cuVzlItPqgs2arRdPgx0ZSmXKVY6qy4aPpM+rtkdUVqWLP/yLTR2nxgVvDXeNdodurFCU/3ZAR&#xa;sGvZxKR0gEhMAU7QCa/AWsLGLYdL0XU6AJP0ZHpjUjyYiGNz9aJ42Zn2TBB8sJ0pQTIfXAC+Az&#xa;fXRMH98I1iIiieANQ1Qh5Rdtskjwv1jz5zqHo2uW20lQulhrE6wSA963O9ibRJZ1AXrcV6Uerb&#xa;jOKu4jRxo416fKcNebqR0FAm9WLRotqV9Kj107D0z0X16ArCWDjLvES1kYX5SOtpiZwo3q7IxR&#xa;byb8axTxDKrijbcnVrtQd7epOlW3IZz2D6w/Uaont13NtmThy4ZzBzgkGjpu4KXj210cLbWiZR&#xa;n156YcS67LEtGRH37oxd1vGKwGkAIrfwuFT5FBhTSfrvPpPqtDFtxth63WjQg+a0mbIoj2o3HF&#xa;h0a/kODc5fw6LUvWxpE79esUbDssSveDkjC+J5lmX9Y1J90vItJK1jsLr1bpJVrW7iUCRiooGN&#xa;sTPIjhV3OGXjXRHblVHon2QeXCZklz8U94uNN8/duf71SsIWhkubIhE0GlolPGL9UsKZv1g8Jt&#xa;jzrZuLs/v6JWLn5NK1GXFLQT4yMmI09RCADRtOMYGyryWeU0XZ504e1nqXjkrVfGsE7tbEwCYK&#xa;kr579BEIysWHBzTSK6lVVOeyB5WvwbC05FFIoRjXL/ITt6v3b5Q+enb1sCYrxd/HLY5m53x4Wd&#xa;q/MQjwTz50tp8vCo/cJynkk7DfhnhlUSp9cXD10p9upI+sbIelny2iuHyzyhjl9bcV/rRP2Ll7&#xa;8Yiqt7U8fgjoIeMKtFB79TVd1B7OJffsJgnEY7/aKLlYHV9zGrCQLdOG27/4S6mroM5runPKsU&#xa;zLzXNz5FPeo1jQTLgmfeIHuy13AhHM5LLjBGfA4JMO59YJef295XdwP6VbGG6PWoEeMEVP8por&#xa;+Am+xagAEmKLck40GAV+6XrAH3iF3UsOsbU/AAm88twRFUPlacifC0URUDghhSUmfYgEPDnDbs&#xa;ufwAfnYfoIUT74abEIUOPm4RQZfTuRJH2jJH2zmPeVnPDThPNVfDDEQXKCeygTcYJ/aBO5hnuo&#xa;E7mGf+hjuYCcf1cpiAeakIAehdCqA+ke/iqcvHYCnhALR9Ih/CmR3nVxn2KNX5qNX0DfPmpFAr&#xa;GKvqgkAql9AnHYvkiBH+pw7+lUMVWUsNuza2Vm3ZAk5jlXA39Y09wElMaj48pPHtb5PjSI/5RH&#xa;/Bl+iSTO5d1Id+KzJnqhyZ04Pz3x+wsntC5T7i4sVBtB/1XfqCRsBKQ/uByfkTYhHBR/+Qs50v&#xa;DJmgB7M/oofZMpZeofpvT92OCFmnQwun73vAvI+1ZJvah2fVErFHLNudB57ywc4NM/gcGyC7sB&#xa;fUNp1Gr8yqwiDwsHjzXxuxYTDGyNCQxM5X/Inkqtvv8he3L9y/932VPDxcTR1d7EzcmFwsjtv8&#xa;8tjMzsnVzdXSxY/0sUTdWy08bQxtzihkdRkCIWVT0r3pBChsdXlWcU0kUypgXXCwW0OPApOA7N&#xa;sYhbUdG0Pn00fRB9xG1A1FbHK7vXflbU5flaRSZIYFPY/drsfM7xf/Ke+fv+5zoQ4mRYGamcvX&#xa;nTnZpoZhGjrdy3zEGRr+swzX3WY8+bGXDfo9q2FT38jskSPpNk9hskf9rkmLqA9yUhmlG46iFn&#xa;M8x0o9O7VwZJW27qfSSgbHSI7QlXrbJsbXpSx+07tWrG04HFC/0LiVEzBOkYY53XX/VZ1iA7cz&#xa;/cszCgvDxAPjSaRtx1vvG4uWW2gbl7fvC8Z4LIEe8vhLjvJpZEjIKO55ZqtTU7RTNy7tEoWzDG&#xa;oZtm2kOqX963MXakC+zhOlCZhU86HpMT6N0V8KjA6jYivzl9cugy8/BSsH+C2ccelfc7thManl&#xa;Vmm/L1oYsszJS5SwPYEL878rTHW1qIsUVH5iU67NjSlvAkGh7Jbdc1Qtq9CFH8vfXoMno8VxVk&#xa;qojCNnJ2ySZxPwT8kilkWBtCDN9HtuaW8cngA0PyJQjXGHQOZ5FMMVEuMhmlmCveg0pCovbENI&#xa;HuxSRorN3FLFLNkcgiNU8qpVkngJdTGZ6OBAnklFpiVP6arCI4zmOqjnoL93I4MBREl9SVBwxW&#xa;a/wpEvM7nFFUerXFNxwOir7/HtRX6zeFF9e5Y6Bz15GAy3CCmEIPnY7rAbLdHmBdZsGK1bHzIn&#xa;Kq6IgRRXawxtGUUExac7SjxbWcWxF8ILhXK5qZzLt8rgqv9lIfhZPy36HTRDY7wYHVUQ1dmvF8&#xa;CFOVN2fJ+Va7hs/N9bxbiMwxocFnhdNrtVW969BDvtmrRNtlnXIoMccSbEf2xY3btRc+XCnO5e&#xa;7ZF4+C3s79/VhgvEXOBZcDbUu0Hm9Roy82Be8NYzZq5P5M62yyzCT7bLq9agfyX1+fOuO/pJwf&#xa;M4VYP5cUCIVNkAUxMcoLhsBiwyH1RrREZUcZkvAd9wUHHeLw+1QV5UaaEnLLT04DYpSu/bw2AN&#xa;akuiSLPGxQHzzDjRKQqGeb5tbV62oqhe2S8x5UD951uygCWKCO6R8vmTtARskIL+eROkCYyTha&#xa;/agybtxS0PzBI+UVvp/oUmeIMp6GznJddbrXZQ5ipO0LUn51RzyzLUQ7LZZRZUdEvU2NBY2GKe&#xa;A3ZjbtFutjJls+Jo4Ls52uXxGb8HCusfSvdazxHfIyAeK2kb/UCrbNOt0ijNy286sh5rMGhIUH&#xa;ktb612IlghTbbCLddEdQWyQFkKyvCrES0PiUnUoXheftD26QJgsQXasNgd+TFB7r9gYmg8uuys&#xa;w/tQnPHLteVfpg+4rtkhTA3p1xmaPTIWvjdmhyo5blWxAmU1mIywzw54KjGARBM2vKVGO+ZuMz&#xa;JUn9O3MIav27brjT9pkzYgti6SMnVbonRfEsJru+utdFvkDCwidR5aBNec/CebmJdbCl8Xs8u6&#xa;Rc7B14pfMs2QWMrKwlc3oe7fryN59LtJ6QT5Fr+wJPss4QUOPcrLVS3e7UHTmShbryPJXH6s2K&#xa;2xNruBo9Lk6CKWCxBQHsacEgqD1hl/UJtzNiYdFSQUtyY/eLzC4jqTyFD5940KY8hqmAwmzctN&#xa;3lHGJpMHhAVQfenPbpk2QiHk34Az7mFEDTGb3n8l0pnzX4pROM+RauM3BOdBUrIzB5aE19ZOVm&#xa;fg3jp1JylaQ+7Uhc/BwSjmHQj5xvEgqm5rY2vO9Qz2WTz8zat7+M0DujPp9PicdQ2RYRiOGu58&#xa;ScP1XH1mfJPj5h/8Fk7xLmUxZoMDBfxP8TJpP9XzD5v/C3VMfbL9uC6Oszi0N20dNN3gN6Tbat&#xa;dHKj7pKv7arpvM5Rh3+lawG54jqp3UEqC8htsz5WSEYc6UWPgqU8AukOW4O3nxFdULAX+xxL4i&#xa;Shqgr+8bH9rJjFZbN6SuKfd/wh2H/+ajB7LUsSePoZAbakTr27twLOmHu1wFlbJ5ipyt5oXiSv&#xa;jXHakSV7pvTN5E3UHVALqo767IqDhG2VGYMnMHHsz1NAIeHa/R3j7ties0N/pGmH/m1zHiDRpp&#xa;ErLLB7u7nKxiKYIkf5GIONzO4nc7m6AKU9ZCqbgceklTVZ9r7YFNcytuzWxTifTgE1LNvbz5QU&#xa;Ywt5ptI1s6Cz+raXVShuQJx+mtvb+9NEmz74CY0OpjXG1h7jCIio3E3fPsiR2tubuVawkqkKq6&#xa;7QHqpiAHZ66WCtv5g9F87p350lZxP1VhYe/rYcG0ufvVLjSMazMore+BNmqEmkkSiadNkXvk3k&#xa;0RC6mXUVmd8PiPcZwLhYNbaf2xizUnROR9BKqtLb/zAYgV6kZwC8XYwxSifXr94h07+QwjtC6x&#xa;lqWmQ5rFMleIFYxgCIDkIwYG5IIlgOqA9Wy2N2qJBWUyJsHtlmxpqhXGyZHvOiUbCMugjNnlT+&#xa;RserNdr/XmPxB6n6lrS2OJ6Ff06LiEnMlFKrYDuWj+Ob7cz5hVINhQZ8B2emjNVDIZw0vcl4ir&#xa;7akOzod+jqHzaUWQ1ZKsKZjrlogmlT9nw581DFlFVlbC6flkpZkVkzbpTdKOUcQ6XJ1ZY+pSXE&#xa;5w3bsa1rBQXo0TyHFlC+lt/HPnONyCqlmtPFc4v+jkem2jAu5s2OLquDNk0TJCC1cbpxDUWzbQ&#xa;qIiuI8aIZP06NJHEnwBQoa6eneESlnkFJ2xqDw5HW45mqGRLaKH2260iIbipn3a9HfsvCWT8eI&#xa;3aJ0LYClpXNyOi3IW0Uvh2JWyYNM4p1IKHg5IU2KKj7w9FTsjf3cgSHbMgKZxAutPtQaQ+GVkq&#xa;aT7HpWoA5nsIv+jckiZhzPJDWffPx5Lf5BeG00ec+TxoBw/GWr/BDwkc2TcVEledd4E2cMrooC&#xa;hEXKpo63t6LGFp/vdZKdGRRFVcS/VpGgVzNeLrZ4Ew+M5ZZbHbrGpFe7YZZG0uzCl15SqsnkZ4&#xa;1l9nwADFdJhWIw7UipbDRsCsm7EH2ybw8HBZsM+4jvFcsdHFZJVHLeFHjpPip50TZocYzvxi4Z&#xa;1HoMPpF2OqY5BJxcLqnBOnC3MtGv6/h4gQysOT2696vx0zkzMcTyD8qMrmssyZ3O2ZPVDixYnn&#xa;uxZldOruNR3LecWGtGP70DG6Us//asx+rdYovdm4ew6+esec97KUzAvkCku7RuhfDccoWYprEm&#xa;P3c2/1wQHeS/UeLejvNkjahIU3IukRi2Vxx6cyUih7WtZgLX/MG/TR7smnKNtchOWAQ5aS1d5C&#xa;5zrDLRglEUXLSBn1fxqqNX4wffSIk46XsrNH/wQWgC765C8Btfp8dLefm9E0Y7FgZT2yyqzEId&#xa;RHX1/YhFsnCm+9FcbpF9k/sic6rXRcgqfeeV5irJ1T+GfaJjeJzmjxNdfwvwjhIyUOlLosvo6c&#xa;u7skReKMxX4lHZdTKBavoitMesLl8f9kGHMDn8gsckq8UN2l+9wjxGeUk2d6SX7E4IevFHcMo8&#xa;mphxlWANRjmvqEtVFtHNm2m3hnIvrdYPGNQOZ2FiDjwczJuI0uNuEitv8los4pehAajy5B11hG&#xa;YFn7HmfcdzgS6M+LxmeP78qsodNL9K9PjdaUtxVny+Y2sTKlAC9Q2WyatmMz2+RedR4HI2xpGs&#xa;n4FXwLCX/svialUlVxzNEPTnxBpXoCG4oG99Hft6Ol7vEKYfwZ9EuDemiOsumU0vG5qXtB7CqR&#xa;v/I245IiU5/89CqOe4IVeEzZOawIux+BuMK+g9pHW7MtZnCH7Mv0jC6b1GNBlhmWRX2oebq0SR&#xa;nJvbRQN2IQHDQy+y5aefPsJGGY1CWtsmTJh/t/2m/gYzVxHOBGURWx/ecJi3NL7xBoUI7+MNBr&#xa;SB8Sf3K415hL9mnU6Z0LwQ5GHc9btmHU10LstZu/yartnJP/kWEygL0MNdrTIN6FZAMORY9o+i&#xa;heDfGDFidvFE4Zdlnl5hB+MCX3tlZX9aYnR2tKW7swvLgWF3wVqTTl6hFhTNn5pVi4gqSBBLFe&#xa;OvHUD3bwTixxPNl4w2piEoclv8pBkgYLRs/kArPse/D7qoTdfWmjQMAj3zBZo/ZB782Slav6BC&#xa;CcD51XpW8iDP1DX3d4OxNwHEdGSoegb7rMSUxRxrRlZFdHbiOi/2uYMtbxsPwm7WwasNSw94Cq&#xa;or3duMcIw9tQlnsEBNX0hvoGMRVcw++WU1h6ecQBdmucCgBI9wO/z6N5On0nLz0A67O0qXtspV&#xa;nbH2uz6H7B1flFEjFxdQjJ6XuDIxCxNBpbXCmzawCHRZkmVl5Lyt7G9b1opVM8IXVxZJM11m6B&#xa;JHwPPsK73Mk5D8An16IX92udlM0xLF1VUZpvvKyxu9lsehwm3nr5csHnWCbaB8prQhBuCJw+uP&#xa;UogRR2O0+Msk8punM8aXOlfrXUeEgJrFIf2PjmXqwlrDjzVFPRuc8mIdcYFdCgKT+qrxA8YFSs&#xa;h8ckJ566P3hZAO/mTxrhFd/WEyJl2PBu/vh9Oj5MIIh55IZkfl7CxbjNwcs+0ToRHH2QftqBO/&#xa;I6rzWGfZLNuXTMqyZ/9amqH0e/O/nCsdXe+93u3AMf00DfC9wcTm/u3/ZHztf/N+sVV45GLU6c&#xa;fwmOrJ7OTxQniHdsPbZSewjJyXUD6WJrlvU9NYvH7q6iOmYy8ASvje+pKzNR5rdeFIjDM01sTX&#xa;CF97x3e4bCkEi1fN6CLUpZAnGcOJo8RgUosf81G7Znm6MdrhkWcFyuPMu0Qe9J1H1w3A57/kkR&#xa;ofk4HIX0+hqG4YlNXqvksiDL+QI/49byJrvVfP5l3dCGz4wWxejctAp9AGzQDVx19OITgc3cxv&#xa;bXaC9HRxTjQ4/TszE7DUvKrywuEz9V3q0nKuD+JbtpbIO6KIvQq4wfzAcCqbPmX2RdSiV1isXh&#xa;Gk4KDxLziO/cVjljLL9Nnly0qbuhvNiYOnzu7mjjeaI8tEHoRZ+JKroCTJNxSeqzGqfPnN9NFW&#xa;6fmJv6hRCcNshLQpB654iy7qIqX1SetaHn9iY/cn6jGmzi06TExdRstZOslguxsHjx94/RyHw3&#xa;4t+i0Czm22+qLFmp+de0JX9LYpdCO09zTDI6K0w428n5elwhkKXjuitA+tC+R6wrVR4mqPndnr&#xa;c3hCmHdae1xYnyC9iOrpbmA2I1bvL7gIN8Be1wsQQLzJWTzxba5UWwPebuzSM7U50tQ8rnlHrz&#xa;ozV5IZ8r9uFKmPnEFYwhEZyRInWlEqyjo3SI6XjcJwvvGMSzqf3x3PG71t+XwvBGJ2anV63hkc&#xa;m2/bopp6Fj+Dusctzyf24hiuOBxEoNF6eUnms2/B/ebgxn+9JOTktL6wCJnasA5g7x/BVkuADq&#xa;VOFGVTGa6OgMJCSrbqhv90DCFH2Q8oIRvZ3hzSkP6Q0qusqoFZzDyXtkTfVm/v1rKeU49Xg9Wk&#xa;hQmekNaY8yV45XWDH9DNPO4XUE27c2YV6NbYqI9AZTICvrBZeNeGLNRjPP2hAxcgL2H+Z560if&#xa;AK0cVu1viy0nfekFnXmgwoYvkiclzTnP2VT3Lv/Pe1/bF6PoZ3kCitdLwrb9Nc3kS2FRM5PMGo&#xa;BH9s/fodQPnIQPvnRfbfDPY5uhKLtjnLW7QY05G2bVnq25TgoeCPXgG52tKnPYaAAWvhrUnCQG&#xa;90Zdhuq73Vv0QoeH/6kd2P4x66BS6RQP68RgiBPx2+4GdT1j6nBVeejG71oy4DD+Je/PrGsB2/&#xa;+Ns/xGTXvyYnA0STNteedD2D2DuMt+FSY8nW7q6a8LDdoHBiVDpblePU/laStV8e2aoeXKJ1Df&#xa;ARaqZSPB9M9F5Mml4qZ0S4yhtZOaA22zb5s5xUPi3kzBRYdaf7CVw+LkgKXN4vCOQ9+dqAK2t7&#xa;2aApa/ucoufV3S2g56FkLpq48pkqrWYuPh65hfJunZRa5I4zEnXYNLsB7N0wcxwMEVx0r5AsbV&#xa;7xqi53U4gKfeStXpljwvoXFnh/QCgLRuMJ5BVpWmUaH5vdmNs8zrAvrQ2X2PEghT4v+CSHgrjm&#xa;pEDDavQPggy29403eBsbGHyS/NIVHyaLAJrySymsNXJNkpkviH/ICja4lrQBEhgYLuE/ZAUcAh&#xa;Psf1bO/bu49E/l3H/a/6mO7t8j/UN8/p0Scf1HlGfM/19p6n/N8e83IfuPHCD8/xeqpSIPDfPP&#xa;bsh/tc9/jTzU/6z+G1BLBwgiRvv3UycAAEwoAABQSwECFAAUAAgICACHDX9MIkb791MnAABMKA&#xa;AAEQAAAAAAAAAAAAAAAAAAAAAAbGliL0NoZXNzVHJlZS5qYXJQSwUGAAAAAAEAAQA/AAAAkicA&#xa;AAAA" ID="ID_37809124" CREATED="1522496040923" MODIFIED="1522496040927"/>
</node>
</node>
<node TEXT="images" POSITION="right" ID="ID_209340361" CREATED="1521562135195" MODIFIED="1522496030032">
<edge COLOR="#7c7c00"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      An add-on may define any number of images as child nodes of the images node. The actual image data has to be placed as base64 encoded binary data into the text of a subnode.
    </p>
    <p>
      The images are saved to the <i>${installationbase}/resources/images</i>&#160;directory.
    </p>
    <p>
      
    </p>
    <p>
      The following images should be present:
    </p>
    <ul>
      <li>
        <i>${name}-icon.png</i>, like <i>oldicons-theme-icon.png</i>. This will be used in the app-on overview.
      </li>
      <li>
        <i>${name}-screenshot-1.png</i>, like <i>oldicons-theme-screenshot-1.png</i>. This will be used in the app-on details dialog. Further images can be included but they are not used yet.
      </li>
    </ul>
    <p>
      Images can be added automatically by releaseAddOn.groovy or must be uploaded into the map via the script <i>Tools-&gt;Scripts-&gt;Insert Binary</i>&#160;since they have to be (base64) encoded as simple strings.
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
</map>
