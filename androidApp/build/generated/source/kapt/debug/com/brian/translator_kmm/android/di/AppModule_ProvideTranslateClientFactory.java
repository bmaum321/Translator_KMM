// Generated by Dagger (https://dagger.dev).
package com.brian.translator_kmm.android.di;

import com.brian.translator_kmm.translate.domain.translate.TranslateClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.ktor.client.HttpClient;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideTranslateClientFactory implements Factory<TranslateClient> {
  private final Provider<HttpClient> httpClientProvider;

  public AppModule_ProvideTranslateClientFactory(Provider<HttpClient> httpClientProvider) {
    this.httpClientProvider = httpClientProvider;
  }

  @Override
  public TranslateClient get() {
    return provideTranslateClient(httpClientProvider.get());
  }

  public static AppModule_ProvideTranslateClientFactory create(
      Provider<HttpClient> httpClientProvider) {
    return new AppModule_ProvideTranslateClientFactory(httpClientProvider);
  }

  public static TranslateClient provideTranslateClient(HttpClient httpClient) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTranslateClient(httpClient));
  }
}