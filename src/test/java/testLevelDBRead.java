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
			// 写入
			DB levelDB = factory.open(new File("d:\\aaa"), options);
			// 遍历
			DBIterator dbIterator = levelDB.iterator();
			while (dbIterator.hasNext()) {
				Entry<byte[], byte[]> entry = dbIterator.next();
				System.out.println(new String(entry.getKey()) + " " + new String(entry.getValue()));
			}
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
