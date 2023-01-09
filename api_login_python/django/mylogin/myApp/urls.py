from . import views
from django.urls import path

urlpatterns = [
    path("", views.home, name="home"),
    path('salir', views.salir, name="salir")
]