package ProjectGUIInterfaces;
import FirstStage.ConceptStructure;
import FirstStage.ObjectStructure;
import java.awt.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNode;
/*
 * Created by JFormDesigner on Fri Oct 26 13:12:17 CAT 2012
 */



/**
 * @author bassel kassem
 */
public class prepareDicData extends JFrame {
    
      public void BuildTree(Vector<ConceptStructure> vec){
        
        DefaultMutableTreeNode      root = new DefaultMutableTreeNode("معاني المعجم");
	DefaultMutableTreeNode      parent;
        DefaultMutableTreeNode      indi;
         int i=0;
	for(ConceptStructure con:vec){
            i++;
            parent = new DefaultMutableTreeNode("-"+i+con.getMeaning());
            
            root.add(parent);
            for(ObjectStructure ob:con.getIndividualNodeVector()){
                indi=new DefaultMutableTreeNode(ob.getWord());
                parent.add(indi);
                indi.add(new DefaultMutableTreeNode("التشكيل: "+ob.getVocalizedWord()));
                for(String ex:ob.getExampleVector()){
                    indi.add(new DefaultMutableTreeNode("مثال: "+ex));
                }
                
               
            }
           
        }
        prepareDataTree.setModel(new DefaultTreeModel(root));
    }
    
    public prepareDicData(Vector<ConceptStructure> vec) {

            initComponents();
            BuildTree(vec);
             setTitle("حجم معطيات المعجم بعد عملية التحضير"+vec.size());
    }
    private void initComponents() {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - bassel kassem
            scrollPane1 = new JScrollPane();
            prepareDataTree = new JTree();

            //======== this ========
            setTitle("\u062a\u062d\u0636\u064a\u0631 \u0645\u0639\u0637\u064a\u0627\u062a \u0627\u0644\u0645\u0639\u062c\u0645 \u0627\u0644\u0639\u0631\u0628\u064a \u0627\u0644\u062a\u0641\u0627\u0639\u0644\u064a");
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
             setPreferredSize(new java.awt.Dimension(500, 500));
            Container contentPane = getContentPane();
            contentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //======== scrollPane1 ========
            {

                    //---- prepareDataTree ----
                    prepareDataTree.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                    prepareDataTree.setForeground(Color.blue);
                    prepareDataTree.setBackground(new Color(204, 204, 255));
                    prepareDataTree.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
                    scrollPane1.setViewportView(prepareDataTree);
            }
            contentPane.add(scrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
           
            pack();
            setLocationRelativeTo(getOwner());
            // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - bassel kassem
    private JScrollPane scrollPane1;
    private JTree prepareDataTree;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
