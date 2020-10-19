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
