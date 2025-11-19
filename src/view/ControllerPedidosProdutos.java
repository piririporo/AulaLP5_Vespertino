/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.PedidosProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerPedidosProdutos extends AbstractTableModel {

    private List lstPedidosProdutos;

    public void setList(List lstPedidosProdutos) {
        this.lstPedidosProdutos = lstPedidosProdutos;
        this.fireTableDataChanged();
    }
    
    public PedidosProdutos getBean(int rowIndex) {
        return (PedidosProdutos) lstPedidosProdutos.get(rowIndex);
    }

    public void addBean(PedidosProdutos pedidosProdutos) {
        lstPedidosProdutos.add(pedidosProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        lstPedidosProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstPedidosProdutos.size();                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PedidosProdutos pedidosProdutos = (PedidosProdutos) lstPedidosProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return pedidosProdutos.getProdutos().getIdprodutos();
        } else if (columnIndex ==1) {
            return pedidosProdutos.getProdutos().getNome();
        } else if (columnIndex ==2) {
            return pedidosProdutos.getQuantidade();
        } else if (columnIndex ==3) {
            return pedidosProdutos.getValorUnitario();
        }else if (columnIndex ==4) {
            return pedidosProdutos.getValorUnitario()*pedidosProdutos.getQuantidade();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Produto";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        } else if ( columnIndex == 4) {
            return "Total";
        } 
        return "";
    }
}
