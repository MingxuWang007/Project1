import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerUI {
    public JFrame view;

    public JButton btnAdd = new JButton( "Add" );
    public JButton btnCancel = new JButton( "Cancel" );

    public JTextField txtCustomerID = new JTextField( 20 );
    public JTextField txtNCame = new JTextField( 20 );
    public JTextField txtPhone = new JTextField( 20 );
    public JTextField txtPin = new JTextField( 20 );

    public AddCustomerUI() {
        this.view = new JFrame( );
        view.setTitle( "Add Customer" );
        view.setSize( 600, 400 );
        view.getContentPane().setLayout( new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS ) );

        String[] labels = {"Customerid ", "Name ", "Address ", "Phone", "Payment info "};

        JPanel line1 = new JPanel( new FlowLayout() );
        line1.add(new JLabel( "CustomerID" ) );
        line1.add(txtCustomerID );
        view.getContentPane().add( line1 );

        JPanel line2 = new JPanel( new FlowLayout() );
        line2.add(new JLabel( "Customer name " ) );
        line2.add(txtNCame );
        view.getContentPane().add( line2 );



        JPanel line4 = new JPanel( new FlowLayout() );
        line4.add(new JLabel("Phone" ) );
        line4.add(txtPhone );
        view.getContentPane().add( line4 );

        JPanel line5 = new JPanel( new FlowLayout() );
        line5.add(new JLabel("Payment info " ) );
        line5.add(txtPin);
        view.getContentPane().add(line5);



        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnAdd);
        panelButtons.add(btnCancel);
        view.getContentPane().add(panelButtons);


        btnAdd.addActionListener(new AddButtonListener());

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                JOptionPane.showMessageDialog(null, "You click on Cancel button!!!");
            }
        });

    }

    public void run() {view.setVisible(true);
    }

    class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            CustomerModel customer = new CustomerModel();

            String id = txtCustomerID.getText();

            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "CustomerID cannot be null!");
                return;
            }

            try {
                customer.mCustomerId = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "CustomerID is invalid!");
                return;
            }

            String name = txtNCame.getText();
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(null, "Product name cannot be empty!");
                return;
            }

            customer.mName = name;




            String phone = txtPhone.getText();
            if (phone.length() == 0) {
                JOptionPane.showMessageDialog(null, "phone number cannot be empty !");
                return;
            }

            customer.mPhone = phone;


            String pin = txtPin.getText();
            if (pin.length() == 0) {
                JOptionPane.showMessageDialog(null, "Product name cannot be empty!");
                return;
            }

            customer.mPin = pin;

            switch (StoreManager.getInstance().getDataAdapter().saveCustomer(customer)) {
                case SQLiteDataAdapter.CUSTOMER_DUPLICATE_ERROR:
                    JOptionPane.showMessageDialog(null, "Customer NOT added successfully! Duplicate customer ID!");
                default:
                    JOptionPane.showMessageDialog(null, "Customer added successfully!" + customer);
            }
        }
    }

}

