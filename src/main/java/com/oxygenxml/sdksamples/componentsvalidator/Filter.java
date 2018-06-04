package com.oxygenxml.sdksamples.componentsvalidator;

import java.util.List;

/**
 * Object containing the filter information collected from the filter XML file.
 */
public class Filter {
 
 /**
  * Filtered toolbar tagged actions
  */
 private List<String> toolbarTaggedActions;
 
 /**
  * Filtered menu or tagged actions
  */
 private List<String> menuOrTaggedActions;
 
 /**
  * Filtered components
  */
 private List<String> components;
 
 /**
  * Filtered actions
  */
 private List<String> accelActions;
 
 /**
  * Filtered content types
  */
 private List<String> contentTypes;
 
 /**
  * Filtered option panes
  */
 private List<String> optionPanes;
 
 /**
  * Filtered options
  */
 private List<String> options;
 
 /**
  * Filtered libraries
  */
 private List<String> libraries;
 
 /**
  * Filtered editor templates
  */
 private List<String> newEditorTamplates;
 
 /**
  * <code>true</code> if debugger perspective is filtered
  */
 private boolean debuggerPerspectiveFiltered = false;
 
 /**
  * Filtered SH markers
  */
 private List<String> shMarkers;
 
 /**
  * Filtered editor pages
  */
 private List<String> toolbarsComposites;
 
 /**
  * code>true</code> if Master Files Support is filtered
  */
 private boolean masterFilesSupportFiltered = false;
 
 /**
  * Filtered editor pages
  */
 private List<String> editorPages;
 /**
  * The name of the file that contains the filter information.
  */
 public static final String EXTENSION_INFO_FILE_NAME = "filter.xml";
 /**
  * Root element name
  */
 static final String ROOT = "filter";
 /**
  * Toolbar tagged action element name
  */
 static final String TOOLBAR_TAGGED_ACTIONS = "toolbarTaggedActions";
 /**
  * Path element name
  */
 static final String PATH = "path";
 /**
  * Components element name
  */
 static final String COMPONENTS = "components";
 /**
  * Tag element name
  */
 static final String TAG = "tag";
 /**
  * Content types element name
  */
 static final String CONTENT_TYPES = "contentTypes";
 /**
  * Content type element name
  */
 static final String CONTENT_TYPE = "contentType";
 /**
  * Menu or tagged action element name
  */
 static final String MENU_OR_TAGGED_ACTIONS = "menuOrTaggedActions";
 /**
  * Key element name
  */
 static final String KEY = "key";
 /**
  * Option panes element name
  */
 static final String OPTION_PANES = "optionPanes";
 /**
  * Options element name
  */
 static final String OPTIONS = "options";
 /**
  * Master files support element name
  */
 static final String MASTER_FILES_SUPPORT = "masterFilesSupport";
 /**
  * Debugger perspective element name
  */
 static final String DEBUGGER_PERSPECTIVE = "debuggerPerspective";
 /**
  * Accel actions element name
  */
 static final String ACCEL_ACTIONS = "accelActions";
 /**
  * Editor pages element name
  */
 static final String EDITOR_PAGE = "editorPage";
 /**
  * Page ID element name
  */
 static final String PAGE_ID = "pageID";
 /**
  * Marker element name
  */
 static final String MARKER = "marker";
 /**
  * Syntax highlight markers element name
  */
 static final String SH_MARKERS = "shMarkers";
 /**
  * Name element
  */
 static final String NAME = "name";
 /**
  * New editor templates element name
  */
 static final String NEW_EDITOR_TAMPLATES = "newEditorTamplates";
 /**
  * Libraries element name
  */
 static final String LIBRARIES = "libraries";
 /**
  * Library element name
  */
 static final String LIBRARY = "library";
 /**
  * Toolbars composites
  */
  static final String TOOLBARS_COMPOSITES = "toolbarComposites";
  /**
   * Toolbars composite
  */
  static final String TOOLBARS_COMPOSITE = "composite";


 /**
  * Get filtered toolbar tagged actions.
  * 
  * @return The filtered toolbar tagged actions.
  */
 public List<String> getToolbarTaggedActions() {
    return toolbarTaggedActions;
  }

 /**
  * Set filtered toolbar tagged actions.
  * 
  * @param toolbarTaggedActions The filtered toolbar tagged actions.
  */
  public void setToolbarTaggedActions(List<String> toolbarTaggedActions) {
    this.toolbarTaggedActions = toolbarTaggedActions;
  }

  /**
   * Get filtered menu or tagged actions.
   * 
   * @return The filtered menu or tagged actions.
   */
  public List<String> getMenuOrTaggedActions() {
    return menuOrTaggedActions;
  }

  /**
   * Set filtered menu or tagged actions.
   * 
   * @param menuOrTaggedActions The filtered menu or tagged actions.
   */
  public void setMenuOrTaggedActions(List<String> menuOrTaggedActions) {
    this.menuOrTaggedActions = menuOrTaggedActions;
  }

  /**
   * Get filtered components.
   * 
   * @return The filtered components.
   */
  public List<String> getComponents() {
    return components;
  }

  /**
   * Set filtered components.
   * 
   * @param components The filtered components.
   */
  public void setComponents(List<String> components) {
    this.components = components;
  }

  /**
   * Get filtered actions.
   * 
   * @return The filtered actions.
   */
  public List<String> getAccelActions() {
    return accelActions;
  }

  /**
   * Set filtered actions.
   * 
   * @param accelActions The  filtered actions.
   */
  public void setAccelActions(List<String> accelActions) {
    this.accelActions = accelActions;
  }

  /**
   * Get filtered content types.
   * 
   * @return The filtered content types.
   */
  public List<String> getContentTypes() {
    return contentTypes;
  }

  /**
   * Set filtered content types.
   *  
   * @param contentTypes The filtered content types.
   */
  public void setContentTypes(List<String> contentTypes) {
    this.contentTypes = contentTypes;
  }

  /**
   * Get filtered option panes.
   * 
   * @return The filtered option panes.
   */
  public List<String> getOptionPanes() {
    return optionPanes;
  }

  /**
   * Set filtered option panes.
   * 
   * @param optionPanes The filtered option panes.
   */
  public void setOptionPanes(List<String> optionPanes) {
    this.optionPanes = optionPanes;
  }

  /**
   * Get filtered options.
   * 
   * @return The filtered options.
   */
  public List<String> getOptions() {
    return options;
  }

  /**
   * Set filtered options.
   * 
   * @param options The filtered options.
   */
  public void setOptions(List<String> options) {
    this.options = options;
  }

  /**
   * Get filtered libraries.
   * 
   * @return The filtered libraries.
   */
  public List<String> getLibraries() {
    return libraries;
  }

  /**
   * Set filtered libraries.
   * 
   * @param libraries The filtered libraries.
   */
  public void setLibraries(List<String> libraries) {
    this.libraries = libraries;
  }

  /**
   * Get filtered editor templates.
   * 
   * @return The filtered editor templates.
   */
  public List<String> getNewEditorTamplates() {
    return newEditorTamplates;
  }

  /**
   * Set filtered editor templates.
   * 
   * @param newEditorTamplates The filtered editor templates.
   */
  public void setNewEditorTamplates(List<String> newEditorTamplates) {
    this.newEditorTamplates = newEditorTamplates;
  }

  /**
   * Check if the debugger perspective is filtered.
   * 
   * @return <code>true</code> if the debugger perspective is filtered.
   */
  public boolean isDebuggerPerspectiveFiltered() {
    return debuggerPerspectiveFiltered;
  }

  /**
   * Set the debugger perspective filtered state.
   * 
   * @param filtered <code>true</code> if the debugger perspective is
   * filtered.
   */
  public void setDebuggerPerspectiveFiltered(boolean filtered) {
    this.debuggerPerspectiveFiltered = filtered;
  }

  /**
   * Get the filtered syntax highlight markers.
   * 
   * @return The filtered syntax highlight markers.
   */
  public List<String> getShMarkers() {
    return shMarkers;
  }

  /**
   * Set the filtered syntax highlight markers.
   *  
   * @param shMarkers The filtered syntax highlight markers.
   */
  public void setShMarkers(List<String> shMarkers) {
    this.shMarkers = shMarkers;
  }

  /**
   * Get the master files support filtered state.
   * 
   * @return <code>true</code> if the master files support is
   * filtered.
   */
  public boolean isMasterFilesSupportFiltered() {
    return masterFilesSupportFiltered;
  }

  /**
   * Get the master files support filtered state.
   * 
   * @param filtered <code>true</code> if the master files support is filtered.
   */
  public void setMasterFilesSupportFiltered(boolean filtered) {
    this.masterFilesSupportFiltered = filtered;
  }

  /**
   * Get the filtered editor pages.
   * 
   * @return The list of filtered editor pages.
   */
  public List<String> getEditorPages() {
    return editorPages;
  }

  /**
   * Set the list of filtered editor pages.
   * 
   * @param editorPages The list of filtered editor pages.
   */
  public void setEditorPages(List<String> editorPages) {
    this.editorPages = editorPages;
  }
  
  /**
   * Set the list of toolbars composites.
   * 
   * @param toolbarsComposites The toolbars composites.
   */
  public void setToolbarsComposites(List<String> toolbarsComposites) {
    this.toolbarsComposites = toolbarsComposites;
  }
  
  /**
   * Get the list of toolbars composites.
   * 
   * @return The toolbars composites.
   */
  public List<String> getToolbarsComposites() {
    return toolbarsComposites;
  }
}