package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame{
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

    public Calculadora(){

        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setEnabled(true);
        setTitle("Calculadora");
        setSize(300,300);
        setVisible(true);

        numero0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digito = "0";
                if (nuevaEntrada) {
                    displayNumeros.setText(digito);
                    nuevaEntrada = false;
                } else {
                    displayNumeros.setText(displayNumeros.getText() + digito);
                }
            }
        });

        numero1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digito = "1";
                if (nuevaEntrada) {
                    displayNumeros.setText(digito);
                    nuevaEntrada = false;
                } else {
                    displayNumeros.setText(displayNumeros.getText() + digito);
                }
            }
        });

        numero2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digito = "2";
                if (nuevaEntrada) {
                    displayNumeros.setText(digito);
                    nuevaEntrada = false;
                } else {
                    displayNumeros.setText(displayNumeros.getText() + digito);
                }
            }
        });

        numero3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digito = "3";
                if (nuevaEntrada) {
                    displayNumeros.setText(digito);
                    nuevaEntrada = false;
                } else {
                    displayNumeros.setText(displayNumeros.getText() + digito);
                }
            }
        });

        numero4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digito = "4";
                if (nuevaEntrada) {
                    displayNumeros.setText(digito);
                    nuevaEntrada = false;
                } else {
                    displayNumeros.setText(displayNumeros.getText() + digito);
                }
            }
        });

        numero5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digito = "5";
                if (nuevaEntrada) {
                    displayNumeros.setText(digito);
                    nuevaEntrada = false;
                } else {
                    displayNumeros.setText(displayNumeros.getText() + digito);
                }
            }
        });

        numero6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digito = "6";
                if (nuevaEntrada) {
                    displayNumeros.setText(digito);
                    nuevaEntrada = false;
                } else {
                    displayNumeros.setText(displayNumeros.getText() + digito);
                }
            }
        });

        numero7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digito = "7";
                if (nuevaEntrada) {
                    displayNumeros.setText(digito);
                    nuevaEntrada = false;
                } else {
                    displayNumeros.setText(displayNumeros.getText() + digito);
                }
            }
        });

        numero8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digito = "8";
                if (nuevaEntrada) {
                    displayNumeros.setText(digito);
                    nuevaEntrada = false;
                } else {
                    displayNumeros.setText(displayNumeros.getText() + digito);
                }
            }
        });

        numero9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String digito = "9";
                if (nuevaEntrada) {
                    displayNumeros.setText(digito);
                    nuevaEntrada = false;
                } else {
                    displayNumeros.setText(displayNumeros.getText() + digito);
                }
            }
        });


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
                    double segundoNumero = Double.parseDouble(displayNumeros.getText());
                    double resultado = 0;

                    switch (operador) {
                        case "+": resultado = primerNumero + segundoNumero; break;
                        case "-": resultado = primerNumero - segundoNumero; break;
                        case "x": resultado = primerNumero * segundoNumero; break;
                        case "/":
                            if (segundoNumero == 0) {
                                displayNumeros.setText("Error: div/0");
                                return;
                            }
                            resultado = primerNumero / segundoNumero;
                            break;
                    }

                    // Muestra entero si no tiene decimales
                    if (resultado == (long) resultado) {
                        displayNumeros.setText(String.valueOf((long) resultado));
                    } else {
                        displayNumeros.setText(String.valueOf(resultado));
                    }

                    primerNumero = resultado;
                    nuevaEntrada = true;

                } catch (NumberFormatException ex) {
                    displayNumeros.setText("Error");
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
}
