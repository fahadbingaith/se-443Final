package com.company;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.openapi.models.V1PodTemplate;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.generic.GenericKubernetesApi;
import io.kubernetes.client.util.generic.KubernetesApiResponse;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ApiException {
        ApiClient client = Config.fromUrl("http://localhost:8000/");
        Configuration.setDefaultApiClient(client);

        CoreV1Api api = new CoreV1Api();
        V1PodList list = api.listNamespacedPod("default", null, null, null, null, null, null, null, null, null);
        for (V1Pod item : list.getItems()) {
            System.out.println(item.getMetadata().getName() + " " + item.getMetadata().getUid());
        }
        ApiClient apiClient = ClientBuilder.standard().build();
        GenericKubernetesApi<V1Pod, V1PodList> podClient =
                new GenericKubernetesApi<>(V1Pod.class, V1PodList.class, "", "v1", "pods", apiClient);

        KubernetesApiResponse<V1Pod> deleteResponse = podClient.delete("default", "pod3");
        if (!deleteResponse.isSuccess()) {
            throw new RuntimeException(deleteResponse.getStatus().toString());

        }
    }
}