// Generated by Dagger (https://dagger.dev).
package com.brian.translator_kmm.di;

import com.brian.translator_kmm.translate.domain.history.HistoryDataSource;
import com.brian.translator_kmm.translate.domain.translate.TranslateClient;
import com.brian.translator_kmm.translate.domain.translate.TranslateUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TestAppModule_ProvideTranslateUseCaseFactory implements Factory<TranslateUseCase> {
  private final Provider<TranslateClient> clientProvider;

  private final Provider<HistoryDataSource> dataSourceProvider;

  public TestAppModule_ProvideTranslateUseCaseFactory(Provider<TranslateClient> clientProvider,
      Provider<HistoryDataSource> dataSourceProvider) {
    this.clientProvider = clientProvider;
    this.dataSourceProvider = dataSourceProvider;
  }

  @Override
  public TranslateUseCase get() {
    return provideTranslateUseCase(clientProvider.get(), dataSourceProvider.get());
  }

  public static TestAppModule_ProvideTranslateUseCaseFactory create(
      Provider<TranslateClient> clientProvider, Provider<HistoryDataSource> dataSourceProvider) {
    return new TestAppModule_ProvideTranslateUseCaseFactory(clientProvider, dataSourceProvider);
  }

  public static TranslateUseCase provideTranslateUseCase(TranslateClient client,
      HistoryDataSource dataSource) {
    return Preconditions.checkNotNullFromProvides(TestAppModule.INSTANCE.provideTranslateUseCase(client, dataSource));
  }
}
