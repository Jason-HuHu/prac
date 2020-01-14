package com.huxl.eshore.fileserver.server;

/**
 *
 * @author huxl
 * @since 2019/12/20-14:16
 */
public class ServerMain {

    public static void main(String[] args) {
        int port = 8899;
        String dirPath = "G:\\FTPService\\";
        if (args.length == 2) {
            port = Integer.parseInt(args[1]);
        }
        new Server(port,dirPath).run();
    }

}
