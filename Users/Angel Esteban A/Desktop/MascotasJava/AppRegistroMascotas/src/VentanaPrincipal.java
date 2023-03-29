import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    
    private HashMap<Integer, Mascota> mascotas = new HashMap<Integer, Mascota>();
    private JTextField txtId, txtNombre, txtColor, txtEdad, txtTipo;
    private JTextArea txtLista;
    private JPanel Ventana;
    private JButton btnAgregar, btnBuscarId, btnBuscarNombre, btnEliminar, btnImprimir, btnSumarEdades;
    private JLabel lblTitulo;

    public VentanaPrincipal() {
        setTitle("Registro de Mascotas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(515, 467);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
    	
    	
    	Ventana = new JPanel();
		setContentPane(Ventana);
		Ventana.setLayout(null);
		Ventana.setBackground(new Color(255, 255, 128));
		
        JLabel label = new JLabel("ID:");
        label.setFont(new Font("Jokerman", Font.PLAIN, 11));
        label.setBounds(34, 107, 24, 37);
        Ventana.add(label);
        
        txtId = new JTextField(10);
        txtId.setBackground(new Color(255, 255, 255));
        txtId.setBounds(71, 111, 123, 28);
        Ventana.add(txtId);
        
        JLabel label_1 = new JLabel("Nombre:");
        label_1.setFont(new Font("Jokerman", Font.PLAIN, 11));
        label_1.setBounds(239, 111, 51, 28);
        Ventana.add(label_1);
        
        txtNombre = new JTextField(10);
        txtNombre.setBounds(289, 111, 152, 28);
        Ventana.add(txtNombre);
        
        JLabel label_2 = new JLabel("Color:");
        label_2.setFont(new Font("Jokerman", Font.PLAIN, 11));
        label_2.setBounds(27, 190, 41, 28);
        Ventana.add(label_2);
        
        txtColor = new JTextField(10);
        txtColor.setBounds(71, 190, 123, 28);
        Ventana.add(txtColor);
        
        JLabel label_3 = new JLabel("Edad:");
        label_3.setFont(new Font("Jokerman", Font.PLAIN, 11));
        label_3.setBounds(249, 150, 41, 28);
        Ventana.add(label_3);
        
        txtEdad = new JTextField(10);
        txtEdad.setBounds(289, 150, 152, 28);
        Ventana.add(txtEdad);
        
        JLabel label_4 = new JLabel("Tipo:");
        label_4.setFont(new Font("Jokerman", Font.PLAIN, 11));
        label_4.setBounds(27, 150, 31, 28);
        Ventana.add(label_4);
        
        txtTipo = new JTextField(10);
        txtTipo.setBounds(71, 150, 123, 28);
        Ventana.add(txtTipo);
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(new Color(128, 255, 128));
        btnAgregar.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 8));
        btnAgregar.setBounds(289, 190, 71, 28);
        btnAgregar.addActionListener(this);
        Ventana.add(btnAgregar);
        
        btnBuscarId = new JButton("Buscar ID");
        btnBuscarId.setBackground(new Color(128, 128, 128));
        btnBuscarId.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 8));
        btnBuscarId.setBounds(249, 363, 100, 28);
        btnBuscarId.addActionListener(this);
        Ventana.add(btnBuscarId);
        
        btnBuscarNombre = new JButton("Buscar Nombre");
        btnBuscarNombre.setBackground(new Color(128, 128, 128));
        btnBuscarNombre.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 8));
        btnBuscarNombre.setBounds(367, 363, 93, 28);
        btnBuscarNombre.addActionListener(this);
        Ventana.add(btnBuscarNombre);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(255, 128, 128));
        btnEliminar.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 8));
        btnEliminar.setBounds(370, 190, 71, 28);
        btnEliminar.addActionListener(this);
        Ventana.add(btnEliminar);
        
        btnImprimir = new JButton("Imprimir Lista");
        btnImprimir.setBackground(new Color(128, 128, 128));
        btnImprimir.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 8));
        btnImprimir.setBounds(249, 311, 103, 28);
        btnImprimir.addActionListener(this);
        Ventana.add(btnImprimir);
        
        btnSumarEdades = new JButton("Sumar Edades");
        btnSumarEdades.setBackground(new Color(128, 128, 128));
        btnSumarEdades.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 8));
        btnSumarEdades.setBounds(367, 311, 93, 28);
        btnSumarEdades.addActionListener(this);
        Ventana.add(btnSumarEdades);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(27, 267, 190, 150);
        Ventana.add(scrollPane);
        
        txtLista = new JTextArea();
        scrollPane.setViewportView(txtLista);
        txtLista.setEditable(false);
        
        lblTitulo = new JLabel("PETS REGISTER");
        lblTitulo.setForeground(new Color(255, 128, 128));
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 50));
        lblTitulo.setBounds(115, 32, 290, 37);
        Ventana.add(lblTitulo);
    }

    private void agregarMascota() {
    	String idStr = txtId.getText();
    	String edadStr = txtEdad.getText();
    	String nombre = txtNombre.getText();
    	String tipo = txtTipo.getText();
    	String color = txtColor.getText();
        
    	if (idStr.isEmpty() || edadStr.isEmpty() || nombre.isEmpty() || tipo.isEmpty() || color.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Hay campos vacios.");
			return;
		}
        
        int id = Integer.parseInt(idStr);
        int edad = Integer.parseInt(edadStr);
        mascotas.put(id, new Mascota(id,nombre, color, edad, tipo));
        JOptionPane.showMessageDialog(null, "Mascota agregada correctamente.");
        limpiarCampos();
    }

    private void buscarMascotaPorId() {
    	
       String idStr = txtId.getText();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un ID de mascota.");
            return;
        }
        
        int id = Integer.parseInt(txtId.getText());
        Mascota mascota = mascotas.get(id);
        if (mascota != null) {
            JOptionPane.showMessageDialog(null, "Mascota encontrada:\n" + mascota.informacion());
        }
        else {
        	JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota con ese ID.");
        	}
        	limpiarCampos();
        	}
    
    private void buscarMascotaPorNombre() {
        String nombre = txtNombre.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre de mascota.");
            return;
        }
        
        boolean encontrada = false;
        String listaMascotas = "Mascotas encontradas:\n";
        for (Mascota mascota : mascotas.values()) {
            if (mascota.getNombre().equalsIgnoreCase(nombre)) {
                listaMascotas += mascota.informacion() + "\n";
                encontrada = true;
            }
        }
        if (encontrada) {
            JOptionPane.showMessageDialog(null,listaMascotas);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota con ese nombre.");
        }
        limpiarCampos();
    }

    private void eliminarMascota() {
    	String idStr = txtId.getText();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un ID de mascota para eliminar.");
            return;
        }
        
        int id = Integer.parseInt(idStr);
        
        if (mascotas.remove(id) != null) {
            JOptionPane.showMessageDialog(null, "Mascota eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota con ese ID.");
        }
        limpiarCampos();
    }

    private void imprimirLista() {
        String listaMascotas = "Lista de Mascotas:\n";
        for (Mascota mascota : mascotas.values()) {
            listaMascotas += mascota.informacion() + "\n";
        }
        txtLista.setText(listaMascotas);
        limpiarCampos();
    }

    private void sumarEdades() {
        int sumaEdades = 0;
        for (Mascota mascota : mascotas.values()) {
            sumaEdades += mascota.getEdad();
        }
        JOptionPane.showMessageDialog(null, "La suma de las edades de las mascotas es: " + sumaEdades);
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtColor.setText("");
        txtEdad.setText("");
        txtTipo.setText("");
    }
    
    
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAgregar) {
			agregarMascota();
		}
		if (e.getSource()==btnBuscarId) {
			buscarMascotaPorId();
		}
		if (e.getSource()==btnBuscarNombre) {
			buscarMascotaPorNombre();
		}
		if (e.getSource()==btnEliminar) {
			eliminarMascota();
		}
		if (e.getSource()==btnImprimir) {
			imprimirLista();
		}
		if (e.getSource()==btnSumarEdades) {
			sumarEdades();
		}
	}

}