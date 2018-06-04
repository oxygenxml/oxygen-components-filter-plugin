package com.oxygenxml.sdksamples.componentsvalidator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.xerces.jaxp.DocumentBuilderFactoryImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ro.sync.exml.ComponentsValidator;
import ro.sync.exml.editor.EditorTemplate;
import ro.sync.exml.plugin.PluginDescriptor;

/**
 * Startup plugin extension.
 *
 * @author  Mircea
 * @created November 26, 2008
 */
public class ComponentsValidatorPluginExtension implements ro.sync.exml.plugin.startup.ComponentsValidatorPluginExtension {
  
  /**
   * Process context.
   *
   * @return A components validator.
   */
  @Override
  public ComponentsValidator getComponentsValidator() {
    // Get the filter information from the filter file
    final Filter filterInformation = getFilterInformationFromFile();
    // Check if the run mode is "developer" (in this case the filtering information
    // is printed in the console) 
    final boolean developerMode = "developer".equals(System.getProperty("components.validator.run.mode"));
    
    return new ComponentsValidator() {
      @Override
      public boolean validateToolbarTaggedAction(String[] toolbarOrAction) {
        String toolbarOrActionPath = canonicalize(toolbarOrAction);
        if (developerMode) {
          System.out.println("Validate toolbar tagged action (" +
              Filter.ROOT + "/" + Filter.TOOLBAR_TAGGED_ACTIONS +"/" + Filter.PATH
              + "): " + toolbarOrActionPath);
        }
        if (filterInformation != null) {
          // Get filtered toolbar tagged action
          List<String> toolbarTaggedActions = filterInformation.getToolbarTaggedActions();
          if (toolbarTaggedActions != null) {
            return !toolbarTaggedActions.contains(toolbarOrActionPath);
          }
        }
        return true;
      }
      @Override
      public boolean validateMenuOrTaggedAction(String[] menuOrAction) {
        String menuOrActionPath = canonicalize(menuOrAction);
        if (developerMode) {
          System.out.println("Validate menu or tagged action (" + 
              Filter.ROOT + "/" + Filter.MENU_OR_TAGGED_ACTIONS +"/" + Filter.PATH
              + "): " + menuOrActionPath);
        }
        if (filterInformation != null) {
          // Get filtered menu or tagged actions
          List<String> menuOrTaggedActions = filterInformation.getMenuOrTaggedActions();
          if (menuOrTaggedActions != null) {
            return !menuOrTaggedActions.contains(menuOrActionPath);
          }
        }
        return true;
      }
      @Override
      public boolean validateComponent(String tag) {
        if (developerMode) {
          System.out.println("Validate component (" +
              Filter.ROOT + "/" + Filter.COMPONENTS +"/" + Filter.TAG
              + "): " +  tag);
        }
        if (filterInformation != null) {
          // Get filtered components
          List<String> components = filterInformation.getComponents();
          if (components != null) {
            return !components.contains(tag);
          }
        }
        return true;
      }
      @Override
      public boolean validateAccelAction(String category, String tag) {
        String actionPath = canonicalize(new String[] {category, tag});
        if (developerMode) {
          System.out.println("Validate accel action (" +
              Filter.ROOT + "/" + Filter.ACCEL_ACTIONS +"/" + Filter.PATH
              + "): " +  actionPath);
        }
        if (filterInformation != null) {
          // Get filtered actions
          List<String> accelActions = filterInformation.getAccelActions();
          if (accelActions != null) {
            return !accelActions.contains(actionPath);
          }
        }
        return true;
      }
      @Override
      public boolean validateContentType(String contentType) {
        if (developerMode) {
          System.out.println("Validate content type (" +
              Filter.ROOT + "/" + Filter.CONTENT_TYPES +"/" + Filter.CONTENT_TYPE
              + "): " +  contentType);
        }
        if (filterInformation != null) {
          // Get filtered content types
          List<String> contentTypes = filterInformation.getContentTypes();
          if (contentTypes != null) {
            return !contentTypes.contains(contentType);
          }
        }
        return true;
      }
      @Override
      public boolean validateOptionPane(String optionPaneKey) {
        if (developerMode) {
          System.out.println("Validate option pane key (" +
              Filter.ROOT + "/" + Filter.OPTION_PANES +"/" + Filter.KEY
              + "): " +  optionPaneKey);
        }
        if (filterInformation != null) {
          // Get filtered option panes
          List<String> optionPanes = filterInformation.getOptionPanes();
          if (optionPanes != null) {
            return !optionPanes.contains(optionPaneKey);
          }
        }
        return true;
      }
      @Override
      public boolean validateOption(String optionKey) {
        if (developerMode) {
          System.out.println("Validate option key (" +
              Filter.ROOT + "/" + Filter.OPTIONS +"/" + Filter.KEY
              + "): " +  optionKey);
        }
        if (filterInformation != null) {
          // Get filtered options
          List<String> options = filterInformation.getOptions();
          if (options != null) {
            return !options.contains(optionKey);
          }
        }
        return true;
      }
      @Override
      public boolean validateLibrary(String library) {
        if (developerMode) {
          System.out.println("Validate library (" +
              Filter.ROOT + "/" + Filter.LIBRARIES +"/" + Filter.LIBRARY
              + "): " +  library);
        }
        if (filterInformation != null) {
          // Get filtered libraries
          List<String> libraries = filterInformation.getLibraries();
          if (libraries != null) {
            return !libraries.contains(library);
          }
        }
        return true;
      }
      @Override
      public boolean validateNewEditorTemplate(EditorTemplate editorTemplate) {
        if (developerMode) {
          System.out.println("Validate editor template name (" +
              Filter.ROOT + "/" + Filter.NEW_EDITOR_TAMPLATES  + "/" + Filter.NAME
              + "): " +  editorTemplate.getName());
        }
        if (filterInformation != null) {
          // Get filtered editor templates
          List<String> editorTemplates = filterInformation.getNewEditorTamplates();
          if (editorTemplates != null) {
            return !editorTemplates.contains(editorTemplate.getName());
          }
        }
        return true;
      }
      @Override
      public boolean isDebuggerPerspectiveAllowed() {
        if (developerMode) {
          System.out.println("Validate debugger perspetive (" + Filter.DEBUGGER_PERSPECTIVE + ")");
        }
        if (filterInformation != null) {
          return !filterInformation.isDebuggerPerspectiveFiltered();
        }
        return true;
      }
      @Override
      public boolean validateSHMarker(String marker) {
        if (developerMode) {
          System.out.println("Validate syntax highlight marker (" +
              Filter.ROOT + "/" + Filter.SH_MARKERS +"/" + Filter.MARKER 
              + "): " +  marker);
        }
        if (filterInformation != null) {
          // Get filtered syntax highlight markers
          List<String> shMarkers = filterInformation.getShMarkers();
          if (shMarkers != null) {
            return !shMarkers.contains(marker);
          }
        }
        return true;
      }
      @Override
      public boolean isMasterFilesSupportAvailable() {
        if (developerMode) {
          System.out.println("Validate master files support (" + Filter.MASTER_FILES_SUPPORT + ")");
        }
        if (filterInformation != null) {
          return !filterInformation.isMasterFilesSupportFiltered();
        }
        return true;
      }
      @Override
      public boolean validateEditorPage(String pageID) {
        if (developerMode) {
          System.out.println("Validate editor page (" +
              Filter.ROOT + "/" + Filter.EDITOR_PAGE +"/" + Filter.PAGE_ID
              + "): " +  pageID);
        }
        if (filterInformation != null) {
          // Get filtered editor pages
          List<String> editorPages = filterInformation.getEditorPages();
          if (editorPages != null) {
            return !editorPages.contains(pageID);
          }
        }
        return true;
      }
      
      @Override
      public boolean validateToolbarComposite(String toolbarCompositeTag) {
        if (developerMode) {
          System.out.println("Validate toolbar composite ("
              + Filter.ROOT + "/" + Filter.TOOLBARS_COMPOSITES
              + "/" + Filter.TOOLBARS_COMPOSITE + "): "
              + toolbarCompositeTag);
        }
        if (filterInformation != null) {
          // Get filtered toolbars composite
          List<String> composites = filterInformation.getToolbarsComposites();
          if (composites != null) {
            return !composites.contains(toolbarCompositeTag);
          }
        }
        return true;
      }
    };
  }
  
  /**
   * Get the filter information from the filter file.
   * 
   * @throws ParserConfigurationException 
   * @throws SAXException 
   */
  public Filter getFilterInformationFromFile() {
    Filter filterInformation = null;
    try {
      ComponentsValidatorPlugin plugIn = ComponentsValidatorPlugin.getInstance();
      PluginDescriptor descriptor = plugIn.getDescriptor();
      File baseDir = descriptor.getBaseDir();
      File extensionFile = new File(baseDir, Filter.EXTENSION_INFO_FILE_NAME);
      if (extensionFile.exists()) {
        // Build the filter information from the filter file
        List<String> toolbarTaggedActions = null;
        List<String> menuOrTaggedActions = null;
        List<String> components = null;
        List<String> accelActions = null;
        List<String> contentTypes = null;
        List<String> optionPanes = null;
        List<String> options = null;
        List<String> libraries = null;
        List<String> newEditorTamplates = null;
        List<String> toolbarsComposites = null;
        boolean debuggerPerspectiveFiltered = false;
        List<String> shMarkers = null;
        boolean masterFilesSupportFiltered = false;
        List<String> editorPages = null;

        DocumentBuilderFactoryImpl factory = new DocumentBuilderFactoryImpl();
        factory.setNamespaceAware(true);
        Document domDocument = factory.newDocumentBuilder().parse(extensionFile);
        Element extensionElement = domDocument.getDocumentElement();
        if (Filter.ROOT.equals(extensionElement.getLocalName())) {
          Node currentChild = extensionElement.getFirstChild();
          while (currentChild != null) {
            if (currentChild.getNodeType() == Node.ELEMENT_NODE) {
              Element currentChildElement = (Element) currentChild;
              if (currentChildElement.getLocalName().equals(Filter.TOOLBAR_TAGGED_ACTIONS)) {
                // Toolbar tagged actions
                if (toolbarTaggedActions == null) {
                  toolbarTaggedActions = new ArrayList<String>();
                }
                populateListWithElementChildContent(toolbarTaggedActions, currentChildElement, Filter.PATH);
              } else if (currentChildElement.getLocalName().equals(Filter.MENU_OR_TAGGED_ACTIONS)) {
                // Menu or tagged actions
                if (menuOrTaggedActions == null) {
                  menuOrTaggedActions = new ArrayList<String>();
                }
                populateListWithElementChildContent(menuOrTaggedActions, currentChildElement, Filter.PATH);
              } else if (currentChildElement.getLocalName().equals(Filter.COMPONENTS)) {
                // Components
                if (components == null) {
                  components = new ArrayList<String>();
                }
                populateListWithElementChildContent(components, currentChildElement, Filter.TAG);
              } else if (currentChildElement.getLocalName().equals(Filter.CONTENT_TYPES)) {
                // Content types
                if (contentTypes == null) {
                  contentTypes = new ArrayList<String>();
                }
                populateListWithElementChildContent(contentTypes, currentChildElement, Filter.CONTENT_TYPE);
              } else if (currentChildElement.getLocalName().equals(Filter.OPTION_PANES)) {
                // Option panes
                if (optionPanes == null) {
                  optionPanes = new ArrayList<String>();
                }
                populateListWithElementChildContent(optionPanes, currentChildElement, Filter.KEY);
              } else if (currentChildElement.getLocalName().equals(Filter.OPTIONS)) {
                // options
                if (options == null) {
                  options = new ArrayList<String>();
                }
                populateListWithElementChildContent(options, currentChildElement, Filter.KEY);
              } else if (currentChildElement.getLocalName().equals(Filter.LIBRARIES)) {
                // Libraries
                if (libraries == null) {
                  libraries = new ArrayList<String>();
                }
                populateListWithElementChildContent(libraries, currentChildElement, Filter.LIBRARY);
              } else if (currentChildElement.getLocalName().equals(Filter.NEW_EDITOR_TAMPLATES)) {
                // New editor templates
                if (newEditorTamplates == null) {
                  newEditorTamplates = new ArrayList<String>();
                }
                populateListWithElementChildContent(newEditorTamplates, currentChildElement, Filter.NAME);
              } else if (currentChildElement.getLocalName().equals(Filter.SH_MARKERS)) {
                // Syntax highlight markers
                if (shMarkers == null) {
                  shMarkers = new ArrayList<String>();
                }
                populateListWithElementChildContent(shMarkers, currentChildElement, Filter.MARKER);
              } else if (currentChildElement.getLocalName().equals(Filter.EDITOR_PAGE)) {
                // Editor pages
                if (editorPages == null) {
                  editorPages = new ArrayList<String>();
                }
                populateListWithElementChildContent(editorPages, currentChildElement, Filter.PAGE_ID);
              } else if (currentChildElement.getLocalName().equals(Filter.ACCEL_ACTIONS)) {
                // Accel actions
                if (accelActions == null) {
                  accelActions = new ArrayList<String>();
                }
                populateListWithElementChildContent(accelActions, currentChildElement, Filter.PATH);
              } else if (currentChildElement.getLocalName().equals(Filter.TOOLBARS_COMPOSITES)) {
                // Toolbars composites
                if (toolbarsComposites == null) {
                  toolbarsComposites = new ArrayList<String>();
                }
                populateListWithElementChildContent(toolbarsComposites, currentChildElement,
                    Filter.TOOLBARS_COMPOSITE);
              } else if (currentChildElement.getLocalName().equals(Filter.DEBUGGER_PERSPECTIVE)) {
                // Debugger perspective 
                debuggerPerspectiveFiltered = true;
              } else if (currentChildElement.getLocalName().equals(Filter.MASTER_FILES_SUPPORT)) {
                // Master files support
                masterFilesSupportFiltered = true;
              }
            }
            // Move to next sibling
            currentChild = currentChild.getNextSibling();
          }
          // Create the filter
          filterInformation = new Filter();
          filterInformation.setAccelActions(accelActions);
          filterInformation.setToolbarsComposites(toolbarsComposites);
          filterInformation.setComponents(components);
          filterInformation.setContentTypes(contentTypes);
          filterInformation.setDebuggerPerspectiveFiltered(debuggerPerspectiveFiltered);
          filterInformation.setEditorPages(editorPages);
          filterInformation.setLibraries(libraries);
          filterInformation.setMasterFilesSupportFiltered(masterFilesSupportFiltered);
          filterInformation.setMenuOrTaggedActions(menuOrTaggedActions);
          filterInformation.setNewEditorTamplates(newEditorTamplates);
          filterInformation.setOptionPanes(optionPanes);
          filterInformation.setOptions(options);
          filterInformation.setShMarkers(shMarkers);
          filterInformation.setToolbarTaggedActions(toolbarTaggedActions);
        }
      }
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
    return filterInformation;
  }

  /**
   * Populate the given list with the text content of the specified element child 
   * nodes.
   * 
   * @param list The list to be populated.
   * @param element The parent element.
   * @param childElementName The name of the child elements.
   */
  private void populateListWithElementChildContent(List<String> list,
      Element element, String childElementName) {
    if (element != null) {
      NodeList childNodes = element.getChildNodes();
      if (childNodes != null) {
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
          Node item = childNodes.item(i);
          if (childElementName.equals(item.getLocalName())) {
            list.add(item.getTextContent());
          }
        }
      }
    }
  }
}