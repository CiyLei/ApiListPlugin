package com.ciy.apilist;

import com.ciy.apilist.util.JTextFieldHintListener;

import javax.swing.*;
import java.awt.event.*;

public class InputDialog extends JDialog {
    private JPanel contentPane;
    private JButton btnNext;
    private JButton buttonCancel;
    private JButton btnGo;
    private JTextField tfUrl;
    private JTextArea textArea1;

    public InputDialog() {
        setContentPane(contentPane);
        setModal(true);
        setSize(850, 750);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnNext);

        btnGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onGo();
            }
        });

        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNext();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        tfUrl.addFocusListener(new JTextFieldHintListener(tfUrl, "请输入Url"));
        tfUrl.setText("http://localhost:8080/apiList.do");
    }

    private void onGo() {
        String url = tfUrl.getText();
        if (!url.isEmpty() && url.startsWith("http")) {
            System.out.println(url);
        }
    }

    private void onNext() {
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        InputDialog dialog = new InputDialog();
        dialog.setVisible(true);
        System.exit(0);
    }
}
