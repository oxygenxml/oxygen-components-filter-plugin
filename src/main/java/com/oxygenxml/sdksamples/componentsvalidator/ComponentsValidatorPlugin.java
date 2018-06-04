package com.oxygenxml.sdksamples.componentsvalidator;

import ro.sync.exml.plugin.Plugin;
import ro.sync.exml.plugin.PluginDescriptor;

/**
 * 	ComponentsValidatorPlugin is a sample plugin for the startup plugin type.
 * 
 * @author Mircea
 * @created November 26, 2008
 */
public class ComponentsValidatorPlugin extends Plugin {
  /**
   * The startup plugin instance.
   */
  private static ComponentsValidatorPlugin instance = null;

  /**
   *  CommentPlugin.
   * 
   *@param descriptor Plugin descriptor.
   */
  public ComponentsValidatorPlugin(PluginDescriptor descriptor) {
    super(descriptor);
    
    if (instance != null) {
      throw new IllegalStateException("Already instantiated!");
    }
    
    instance = this;
  }
  
  /**
   * Get the plugin instance.
   * 
   * @return the shared plugin instance.
   */
  public static ComponentsValidatorPlugin getInstance() {
    return instance;
  }
}