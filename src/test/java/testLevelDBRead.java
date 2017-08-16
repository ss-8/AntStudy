import static org.iq80.leveldb.impl.Iq80DBFactory.bytes;
import static org.iq80.leveldb.impl.Iq80DBFactory.factory;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;

import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBIterator;
import org.iq80.leveldb.Options;
import org.junit.Test;

public class testLevelDBRead {

	@Test
	public void test() {
		Options options = new Options();
		options.createIfMissing(true);
		options.maxOpenFiles(256);
		options.blockSize(32 * 1024);
		options.writeBufferSize(100000000);
		try {
			System.out.println("start");
			// 写入
			DB levelDB = factory.open(new File("D:\\Develop\\levelDB\\f798e22f-4903-4ed6-97f1-6494f95d1299true"), options);
			// 遍历
			DBIterator dbIterator = levelDB.iterator();
			int i=0;
			while (dbIterator.hasNext()) {
				i++;
				Entry<byte[], byte[]> entry = dbIterator.next();
				System.out.println(new String(entry.getKey()) + "--" + new String(entry.getValue()));
				if(i>10){
					break;
				}
			}
			System.out.println("row num:"+i);
			//查询
			long starttime=System.currentTimeMillis();
			byte[] bytes = levelDB.get("10".getBytes("utf-8"));
			System.out.println(System.currentTimeMillis()-starttime);
			if (bytes!=null)
				System.out.println(new String(bytes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
