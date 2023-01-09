from django.contrib import admin
from django.urls import path,include

urlpatterns = [
    path('login/', admin.site.urls),
    path('',include("myApp.urls")),
    path('accounts/', include('django.contrib.auth.urls')),

]