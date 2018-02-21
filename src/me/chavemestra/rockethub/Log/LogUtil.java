/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.chavemestra.rockethub.Log;

import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class LogUtil {

    private static Logger logger = Logger.getLogger("Minecraft");

    public enum TipoLog {

        Inicializacao(ConsoleColors.ANSI_GREEN, "Inicializacao"),
        Encerrando(ConsoleColors.ANSI_RED, "Encerramento"),
        Debug(ConsoleColors.ANSI_PURPLE, "Debug");
        
        private String color;
        private String tipo;

        private TipoLog(String color, String tipo) {
            this.color = color;
            this.tipo = tipo;
        }

        private String getColor() {
            return this.color;
        }
        
        private String getTipo() {
            return this.tipo;
        }

    };

    public static void log(String msg, TipoLog log) {
        logger.info(log.getColor() + "[RocketHub / "+log.getTipo()+"] " + msg + ConsoleColors.ANSI_RESET);
    }
}
