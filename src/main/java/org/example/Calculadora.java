package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private JPanel mainPanel;
    private JButton signoDivision;
    private JButton numero1;
    private JButton signoResta;
    private JButton numero2;
    private JButton numero7;
    private JButton signoSuma;
    private JButton numero5;
    private JButton numero0;
    private JButton numero4;
    private JButton signoLimpiar;
    private JLabel displayNumeros;
    private JButton numero8;
    private JButton signoMultiplicacion;
    private JButton numero9;
    private JButton numero6;
    private JButton numero3;
    private JButton signoResultado;

    private double primerNumero = 0;
    private String operador = "";
    private boolean nuevaEntrada = true;

    public Calculadora() {
        initComponents();
        initListeners();

        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setSize(320, 420);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        mainPanel = new JPanel(new BorderLayout(8, 8));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        displayNumeros = new JLabel("0", SwingConstants.RIGHT);
        displayNumeros.setFont(displayNumeros.getFont().deriveFont(Font.BOLD, 32f));
        displayNumeros.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        mainPanel.add(displayNumeros, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 8, 8));

        numero7 = new JButton("7");
        numero8 = new JButton("8");
        numero9 = new JButton("9");
        signoDivision = new JButton("/");

        numero4 = new JButton("4");
        numero5 = new JButton("5");
        numero6 = new JButton("6");
        signoMultiplicacion = new JButton("x");

        numero1 = new JButton("1");
        numero2 = new JButton("2");
        numero3 = new JButton("3");
        signoResta = new JButton("-");

        numero0 = new JButton("0");
        signoLimpiar = new JButton("C");
        signoResultado = new JButton("=");
        signoSuma = new JButton("+");

        buttonPanel.add(numero7);
        buttonPanel.add(numero8);
        buttonPanel.add(numero9);
        buttonPanel.add(signoDivision);
        buttonPanel.add(numero4);
        buttonPanel.add(numero5);
        buttonPanel.add(numero6);
        buttonPanel.add(signoMultiplicacion);
        buttonPanel.add(numero1);
        buttonPanel.add(numero2);
        buttonPanel.add(numero3);
        buttonPanel.add(signoResta);
        buttonPanel.add(numero0);
        buttonPanel.add(signoLimpiar);
        buttonPanel.add(signoResultado);
        buttonPanel.add(signoSuma);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
    }

    private void initListeners() {
        ActionListener digitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digito = ((JButton) e.getSource()).getText();
                if (nuevaEntrada || displayNumeros.getText().equals("0")) {
                    displayNumeros.setText(digito);
                    nuevaEntrada = false;
                } else {
                    displayNumeros.setText(displayNumeros.getText() + digito);
                }
            }
        };

        numero0.addActionListener(digitListener);
        numero1.addActionListener(digitListener);
        numero2.addActionListener(digitListener);
        numero3.addActionListener(digitListener);
        numero4.addActionListener(digitListener);
        numero5.addActionListener(digitListener);
        numero6.addActionListener(digitListener);
        numero7.addActionListener(digitListener);
        numero8.addActionListener(digitListener);
        numero9.addActionListener(digitListener);

        signoSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerNumero = Double.parseDouble(displayNumeros.getText());
                operador = "+";
                nuevaEntrada = true;
            }
        });

        signoResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerNumero = Double.parseDouble(displayNumeros.getText());
                operador = "-";
                nuevaEntrada = true;
            }
        });

        signoMultiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerNumero = Double.parseDouble(displayNumeros.getText());
                operador = "x";
                nuevaEntrada = true;
            }
        });

        signoDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerNumero = Double.parseDouble(displayNumeros.getText());
                operador = "/";
                nuevaEntrada = true;
            }
        });

        signoResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double segundoNumero = obtenerValorActual();
                    double resultado = calcularResultado(segundoNumero);

                    if (resultado == (long) resultado) {
                        displayNumeros.setText(String.valueOf((long) resultado));
                    } else {
                        displayNumeros.setText(String.valueOf(resultado));
                    }

                    primerNumero = resultado;
                    nuevaEntrada = true;
                } catch (DivisionPorCeroException | EntradaInvalidaException ex) {
                    displayNumeros.setText(ex.getMessage());
                }
            }
        });

        signoLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayNumeros.setText("0");
                primerNumero = 0;
                operador = "";
                nuevaEntrada = true;
            }
        });
    }

    private double obtenerValorActual() throws EntradaInvalidaException {
        try {
            return Double.parseDouble(displayNumeros.getText());
        } catch (NumberFormatException ex) {
            throw new EntradaInvalidaException();
        }
    }

    private double calcularResultado(double segundoNumero) throws DivisionPorCeroException {
        switch (operador) {
            case "+":
                return primerNumero + segundoNumero;
            case "-":
                return primerNumero - segundoNumero;
            case "x":
                return primerNumero * segundoNumero;
            case "/":
                if (segundoNumero == 0) {
                    throw new DivisionPorCeroException();
                }
                return primerNumero / segundoNumero;
            default:
                return segundoNumero;
        }
    }
}
