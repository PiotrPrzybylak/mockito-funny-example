package org.masteukodeu.example.mockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {

    @Test
    public void test() {

        Repository repository = mock(Repository.class);
        Service service = new Service(repository);
        when(service.find()).thenReturn("something");

        String result = service.find();

        assertEquals(result, "something");
    }

    private static class Service {
        private Repository repository;

        public Service(Repository repository) {
            this.repository = repository;
        }

        public String find() {
            return repository.findInRepo();
        }
    }

    private interface Repository {
        String findInRepo();
    }
}

