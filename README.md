# oxygen-components-filter-plugin
This sample plugin allows customization of oXygen XML Editor components like menus, toolbars, views, and actions. For instance, you can                 use it to filter out the actions you do not use in the menus or toolbar. For more technical details see http://www.oxygenxml.com/doc/ug-oxygen/index.html?q=/doc/ug-oxygen/concepts/components-validation-plugin.html

## Installation

This add-on is compatible with Oxygen XML Editor (or XML Author) version 17.0 or higher. 

To install it the add-on, follow these instructions:

1. Go to **Help->Install new add-ons** to open an add-on selection dialog box.
2. Enter or paste https://raw.githubusercontent.com/oxygenxml/oxygen-components-filter-plugin/master/addon.xml in the **Show add-ons from** field.
3. Select the **Git Support (Experimental)** add-on and click **Next**.
4. Select the **I accept all terms of the end user license agreement** option and click **Finish**.
5. Restart the application.

Result: 
This type of plugin can be used to remove various toolbar and menu actions or various visual components from an Oxygen standalone installation by modifying its "filter.xml" configuration file.
As a default behavior the plugin removes the "Grid" editing mode.

Copyright and License
---------------------
Copyright 2018 Syncro Soft SRL.

This project is licensed under [Apache License 2.0](https://github.com/oxygenxml/oxygen-git-plugin/blob/master/LICENSE)
