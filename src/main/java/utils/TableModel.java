package utils;
import models.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class TableModel {

    public static DefaultTableModel listToTableModelEstudiantes(List<Estudiante> estudiantes) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Nombre");
        columnNames.add("Grado Escolar");
        columnNames.add("Edad");
        columnNames.add("Telefono");
        columnNames.add("Escuela Procedencia");
        Vector<Vector<Object>> data = new Vector<>();
        for (Estudiante estudiante : estudiantes) {
            Vector<Object> row = new Vector<>();
            row.add(estudiante.getId());
            row.add(estudiante.getNombre());
            row.add(estudiante.getGradoEscolar());
            row.add(estudiante.getEdad());
            row.add(estudiante.getTelefono());
            row.add(estudiante.getEscuelaProcedencia());
            data.add(row);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static DefaultTableModel listToTableModelHorarios(List<Horario> horarios) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Dia");
        columnNames.add("Hora Inicio");
        columnNames.add("Hora Fin");
        columnNames.add("Tutor");
        Vector<Vector<Object>> data = new Vector<>();
        for (Horario horario : horarios) {
            Vector<Object> row = new Vector<>();
            row.add(horario.getId());
            row.add(horario.getDia());
            row.add(horario.getHoraInicio());
            row.add(horario.getHoraFin());
            row.add(horario.getTutor().getNombre());
            data.add(row);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static DefaultTableModel listToTableModelMaterias(List<Materia> materias) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Nombre");
        columnNames.add("Nivel");
        columnNames.add("Descripcion");
        Vector<Vector<Object>> data = new Vector<>();
        for (Materia materia : materias) {
            Vector<Object> row = new Vector<>();
            row.add(materia.getId());
            row.add(materia.getNombre());
            row.add(materia.getNivel());
            row.add(materia.getDescripcion());
            data.add(row);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static DefaultTableModel listToTableModelTutor(List<Tutor> tutores) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Nombre");
        columnNames.add("Telefono");
        columnNames.add("Correo");
        columnNames.add("Especialidad");
        Vector<Vector<Object>> data = new Vector<>();
        for (Tutor tutor : tutores) {
            Vector<Object> row = new Vector<>();
            row.add(tutor.getId());
            row.add(tutor.getNombre());
            row.add(tutor.getTelefono());
            row.add(tutor.getCorreo());
            row.add(tutor.getEspecialidad());
            data.add(row);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static DefaultTableModel listToTableModelTutoria(List<Tutoria> tutorias) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Fecha");
        columnNames.add("Hora");
        columnNames.add("Estado");
        columnNames.add("Tutor");
        columnNames.add("Estudiante");
        columnNames.add("Materia");
        Vector<Vector<Object>> data = new Vector<>();
        for (Tutoria tutoria : tutorias) {
            Vector<Object> row = new Vector<>();
            row.add(tutoria.getId());
            row.add(tutoria.getFecha());
            row.add(tutoria.getHora());
            row.add(tutoria.getEstado());
            row.add(tutoria.getTutor().getNombre());
            row.add(tutoria.getEstudiante().getNombre());
            row.add(tutoria.getMateria().getNombre());
            data.add(row);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
}
