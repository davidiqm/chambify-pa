/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel y David
 */
public class MiModelo extends DefaultTableModel
{
   @Override
   public boolean isCellEditable (int row, int column)
   {
       return false;
   }
}
