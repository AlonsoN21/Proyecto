/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author beto
 */
public class IdControl {
    String controlFile;
    private final Map<String, Integer> idMap;
    

    public IdControl(String controlFile) throws IOException {
        this.controlFile = controlFile;
        this.idMap = new HashMap<>();
        loadIds();
    }

    private void loadIds() throws IOException {
        File file = new File(controlFile);
        if (!file.exists()) {
            // Crear el archivo si no existe
            file.createNewFile();
            saveIds(); // Guardar un mapa vacío para inicializar el archivo
            return;
        }
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader(controlFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                idMap.put(parts[0], Integer.valueOf(parts[1]));
            }
        }
    }

    private void saveIds() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(controlFile))) {
            for (Map.Entry<String, Integer> entry : idMap.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        }
    }

    public synchronized int getNextId(String fileName) throws IOException {
        int nextId = idMap.getOrDefault(fileName, 1);
        idMap.put(fileName, nextId + 1);
        saveIds();
        return nextId;
    }
}
