package pl.codegym.task.task18.task1812;

import java.io.*;

/* 
Rozszerzanie AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream
{
    private AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream){
        this.original = amigoOutputStream;
    }

    @Override
    public void flush() throws IOException{
        original.flush();
    }

    @Override
    public void write(int b) throws IOException{
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Czy naprawdę chcesz zamknąć strumień? T/N");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String coWpisal = br.readLine();
        br.close();
        if (coWpisal.equals("T")){
            original.close();
        }
    }


}

