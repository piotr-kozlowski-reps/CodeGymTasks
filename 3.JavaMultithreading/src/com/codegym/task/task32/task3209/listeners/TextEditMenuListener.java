package com.codegym.task.task32.task3209.listeners;

import com.codegym.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class TextEditMenuListener implements MenuListener {

    //fields
    private View view;

    //constructors
    public TextEditMenuListener(View view){
        this.view = view;
    }


    //
    @Override
    public void menuSelected(MenuEvent menuEvent) {
        JMenu menu = (JMenu) menuEvent.getSource();
        Component[] menuItems = menu.getMenuComponents();
        for (Component menuItem : menuItems){
            menuItem.setEnabled(view.isHtmlTabSelected());
        }

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }

}


//13.3.3. For each menu item, call the setEnabled method, passing the return value of the view's isHtmlTabSelected() method
// as an argument. Run the application and be sure that the style, align, color and font menu items are available only
// when the HTML tab is active, not when the Text tab is active.
//
//
//Requirements:


//4. The TextEditMenuListener class's menuSelected(MenuEvent menuEvent) method should set the availability of the menu items in the
// style, align, color, and font menus depending on the selected tab.