/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pfp.pnl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouz
 */
public class pnlRegistroDigitar extends javax.swing.JPanel {

    /**
     * Creates new form pnlRegistroAlterar
     */
    public pnlRegistroDigitar() {
        initComponents();
    }
    
    private void carregarDados() {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                try {
                    URL url = new URL("http://localhost:8080/projetosAtribuicao");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");
                    
                    if (conn.getResponseCode() == 200) {
                        
                                
                        Reader reader = new InputStreamReader(conn.getInputStream());
                        Type listType = new TypeToken<List<pnlRegistroDigitar.Atribuicao>>(){}.getType();
                        List<pnlRegistroDigitar.Atribuicao> lista = new Gson().fromJson(reader, listType);
                        
                        DefaultTableModel modelo = (DefaultTableModel) TblLista.getModel();
                        modelo.setRowCount(0); // limpa a tabela antes de adicionar
                        for (pnlRegistroDigitar.Atribuicao f : lista) {
                            lblNome.setText(f.nomeProjeto);
                            lblEmpresa.setText(f.empresaCliente);
                            lblStatus.setText(f.status);
                            lblTempo.setText(f.dataInicio);
                            lblData.setText(f.dataPrevisaoEntrega);
                            modelo.addRow(new Object[]{
                                f.titulo_item,
                                f.quantidade
                            });
                        }

                        reader.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao buscar dados: " + conn.getResponseCode());
                    }

                    conn.disconnect();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
                
                try {
                    URL url = new URL("http://localhost:8080/pedidoEstoqueProj");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");
                    
                    if (conn.getResponseCode() == 200) {
                        
                                
                        Reader reader = new InputStreamReader(conn.getInputStream());
                        Type listType = new TypeToken<List<pnlRegistroDigitar.Estoque>>(){}.getType();
                        List<pnlRegistroDigitar.Estoque> lista = new Gson().fromJson(reader, listType);
                        
                        DefaultTableModel modelo = (DefaultTableModel) TblLista.getModel();
                        modelo.setRowCount(0); // limpa a tabela antes de adicionar
                        for (pnlRegistroDigitar.Estoque f : lista) {
                            modelo.addRow(new Object[]{
                                f.itemProjeto,
                                f.quantidadeAtendida
                            });
                        }

                        reader.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao buscar dados: " + conn.getResponseCode());
                    }

                    conn.disconnect();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
                return null;
            }
        };
        worker.execute();
    }
    
    public class Atribuicao{
        String nomeProjeto;
        String dataInicio;
        String dataPrevisaoEntrega;
        String status;
        long empresaClienteId;
        String empresaCliente;
        long funcionarioResponsavelId;
        String funcionarioResponsavel;
        long projetoItemId;
        String titulo_item;
        Integer quantidade;   
    }
    
    public class Estoque{
        long itemProjetoId;
        long produtoEstoqueId;
        int quantidadeSolicitada;
        int quantidadeAtendida;
        String dataPedido;
        String status;
        String itemProjeto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        btnCancelar1 = new javax.swing.JButton();
        lblTempo = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TblEstoque = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        TblLista = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1306, 780));
        setMinimumSize(new java.awt.Dimension(1306, 780));
        setPreferredSize(new java.awt.Dimension(1306, 780));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel12.setText("Registro");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblNome.setText("Nome");

        lblEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblEmpresa.setText("Empresa");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblStatus.setText("Status");

        lblData.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblData.setText("Data de entrega");

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        lblTempo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTempo.setText("Tempo restante");

        TblEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblEstoque.setMaximumSize(new java.awt.Dimension(1306, 780));
        TblEstoque.setMinimumSize(new java.awt.Dimension(1306, 780));
        TblEstoque.setPreferredSize(new java.awt.Dimension(1306, 780));
        jScrollPane7.setViewportView(TblEstoque);

        TblLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TblLista.setMaximumSize(new java.awt.Dimension(1306, 780));
        TblLista.setMinimumSize(new java.awt.Dimension(1306, 780));
        TblLista.setPreferredSize(new java.awt.Dimension(1306, 780));
        jScrollPane8.setViewportView(TblLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 642, Short.MAX_VALUE)
                .addComponent(btnCancelar1)
                .addGap(601, 601, 601))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblEmpresa)
                            .addComponent(lblStatus)
                            .addComponent(lblData)
                            .addComponent(lblTempo)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar1)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblEstoque;
    private javax.swing.JTable TblLista;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTempo;
    // End of variables declaration//GEN-END:variables
}
