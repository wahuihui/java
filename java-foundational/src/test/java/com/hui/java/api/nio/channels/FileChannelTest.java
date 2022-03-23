package com.hui.java.api.nio.channels;

import org.testng.annotations.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/22 13:48
 * @since JDK8
 */

public class FileChannelTest {

    /**
     * FileChannel的获取
     */
    @Test
    public void testGetChannel(){
        try (
                FileInputStream fileInputStream = new FileInputStream("E:\\nio\\write.flac");
                FileOutputStream fileOutputStream = new FileOutputStream("E:\\nio\\write_copy.flac");

                final FileChannel readChannel = fileInputStream.getChannel();
                final FileChannel writeChannel = fileOutputStream.getChannel()

        ){
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用FileChannel和ByteBuffer实现拷贝文件
     */
    @Test
    public void testFileChannelWithByteBufferFileCopy(){

        try (
                FileInputStream fileInputStream = new FileInputStream("E:\\nio\\write.flac");
                FileOutputStream fileOutputStream = new FileOutputStream("E:\\nio\\write_copy.flac");

                final FileChannel readChannel = fileInputStream.getChannel();
                final FileChannel writeChannel = fileOutputStream.getChannel()
        ){
            ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
            System.out.println("读取文件之前ByteBuffer的 position是："+byteBuffer.position()+" limit是："+byteBuffer.limit());

            while (readChannel.read(byteBuffer)!=-1){
                System.out.println("flip之前 ByteBuffer的 position是："+byteBuffer.position()+" limit是 "+ byteBuffer.limit());
                byteBuffer.flip();
                System.out.println("flip之后/write之前 ByteBuffer的 position是："+byteBuffer.position()+" limit是 "+ byteBuffer.limit());
                writeChannel.write(byteBuffer);
                System.out.println("clear之前/write之后 ByteBuffer的 position是："+byteBuffer.position()+" limit是 "+ byteBuffer.limit());
                byteBuffer.clear();
                System.out.println("clear之后 ByteBuffer的 position是："+byteBuffer.position()+" limit是 "+ byteBuffer.limit());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * 使用FileChannel和MappedByteBuffer实现拷贝文件
     * 拷贝的文件必须小于2GB
     */
    @Test
    public void testFileChannelMappedByteBufferFileCopyLessThan2GB(){
        try (
                RandomAccessFile readRandomAccessFile = new RandomAccessFile("E:\\nio\\file.mp4","r");
                RandomAccessFile writeRandomAccessFile = new RandomAccessFile("E:\\nio\\file_copy.mp4","rw");

                final FileChannel readFileChannel = readRandomAccessFile.getChannel();
                final FileChannel writeFileChannel = writeRandomAccessFile.getChannel()
        ){
            final long fileSize = readFileChannel.size();
            System.out.println("file.mp4文件的大小是："+fileSize/1024/1024 +" MB");

            MappedByteBuffer readMappedByteBuffer = readFileChannel.map(FileChannel.MapMode.READ_ONLY,0,fileSize);
            MappedByteBuffer writeMappedByteBuffer = writeFileChannel.map(FileChannel.MapMode.READ_WRITE,0,fileSize);

            for (long i = 0; i < fileSize; i++) {
                final byte data = readMappedByteBuffer.get();
                writeMappedByteBuffer.put(data);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * FileChannel和MappedByteBuffer实现2GB以上文件拷贝
     */
    @Test
    public void testFileChannelWithMappedByteBufferFileCopyMoreThen2GB(){

        try (
                RandomAccessFile readRandomAccessFile = new RandomAccessFile("E:\\office\\11\\duohe2.mp4","r");
                RandomAccessFile writeRandomAccessFile = new RandomAccessFile("E:\\nio\\bigFile_copy.mp4","rw");

                final FileChannel readRandomAccessFileChannel = readRandomAccessFile.getChannel();
                final FileChannel writeRandomAccessFileChannel = writeRandomAccessFile.getChannel()
        ){
            final long fileSize = readRandomAccessFileChannel.size();

            long everySize = 1024*1024*1024;

            long maxSize = 2L*1024*1024*1024;

            long copyCount = 1;

            if (fileSize>maxSize){
                copyCount = fileSize%everySize==0?fileSize/everySize:fileSize/everySize+1;
            }
            System.out.println("文件拷贝的次数是："+copyCount);

            for (long i = 0; i < copyCount; i++) {
                long currentStartCopyPosition = i*everySize;
                System.out.println("当前循环文件拷贝的位置是："+currentStartCopyPosition);

                long actualCopySize = Math.min(fileSize - currentStartCopyPosition, everySize);
                System.out.println("当前循环实际拷贝的大小是："+actualCopySize+" 字节");


                MappedByteBuffer readMappedByteBuffer = readRandomAccessFileChannel.map(FileChannel.MapMode.READ_ONLY,currentStartCopyPosition,actualCopySize);
                MappedByteBuffer writeMappedByteBuffer = writeRandomAccessFileChannel.map(FileChannel.MapMode.READ_WRITE,currentStartCopyPosition,actualCopySize);

                for (long j = 0; j < actualCopySize; j++) {
                    final byte data = readMappedByteBuffer.get();
                    writeMappedByteBuffer.put(data);
                }
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}



















