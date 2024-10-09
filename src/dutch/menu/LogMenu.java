/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.menu;

import javax.swing.JLabel;
import bbdd.dao.pojo.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author migue
 */
public class LogMenu extends JPanel{
    Menu owner;
    
    JTable table;
    JButton backButton;
    
    public LogMenu(Menu owner){
        this.owner = owner;
        
        initTable();
        
        initBackButton();
        
        setUp();
        
        
    }
    public void initBackButton(){
        backButton = new JButton("BACK");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backAction();
            }
        });
    }
    public void backAction(){
        owner.setUp(Menu.DEFAULT_MENU);
    }
    public void setUp(){
        this.add(new JScrollPane(table));
        this.add(backButton);
        this.setVisible(true);
    }
    public void initTable(){
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{
                
                }, 
                new String[]{
                    "Num",
                    "Fecha",
                    "Ganador"
                }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
           
        };
        
        tableModel.addRow(new String[]{"1", "12/06/2024", "Miguel"});
        
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);
        
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getTableHeader().setResizingAllowed(false);
        table.setFillsViewportHeight(true);
    }
}
