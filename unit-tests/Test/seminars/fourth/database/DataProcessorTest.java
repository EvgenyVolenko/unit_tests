package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DataProcessorTest {

    @Test
    void dataProcessorTest(){
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);

        when(database.query(anyString())).thenReturn(Arrays.asList("Data11", "Data21", "Data31"));

        List<String> res = database.query(anyString());

        verify(database, times(1)).query(anyString());

        assertThat(res).isNotEmpty()
                .hasSize(3)
                .isEqualTo(Arrays.asList("Data11", "Data21", "Data31"));
    }

}