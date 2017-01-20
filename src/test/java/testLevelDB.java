import static org.iq80.leveldb.impl.Iq80DBFactory.bytes;
import static org.iq80.leveldb.impl.Iq80DBFactory.factory;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;

import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBIterator;
import org.iq80.leveldb.Options;
import org.junit.Test;

public class testLevelDB {

	@Test
	public void test() {
		Options options = new Options();
		options.createIfMissing(true);
		options.maxOpenFiles(256);
		options.blockSize(32 * 1024);
		options.writeBufferSize(100000000);
		DB levelDB=null;
		try {
			//写入
			levelDB = factory.open(new File("d:\\aaa"), options);
			for(int i=0;i<10;i++){
				levelDB.put(bytes(i+""), bytes("我爱levelDB"+i));
			}
			//读取
			DBIterator dbIterator = levelDB.iterator();
			while (dbIterator.hasNext()) {
				Entry<byte[], byte[]> entry = dbIterator.next();
				System.out.println(new String(entry.getValue()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
